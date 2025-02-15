package com.athletics.processor;

import com.athletics.model.Athlete;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ResultsProcessor {
    private List<Athlete> athletes = new ArrayList<>();

    public void loadResults(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            String[] data = line.split(", ");
            if (data.length != 4) continue;

            String[] nameParts = data[0].split(" ");
            if (nameParts.length != 2) continue;

            String lastName = nameParts[0];
            String firstName = nameParts[1];
            String gender = data[1];
            String distance = data[2];
            String time = data[3];

            Athlete athlete = new Athlete(lastName, firstName, gender, distance, time);
            athletes.add(athlete);

            System.out.println("Загружен спортсмен: " + lastName + " " + firstName + " - " + gender + ", " + distance + ", " + time);
        }
        reader.close();
    }

    public List<Athlete> getFastestRunners(String distance, String gender, int n) {
        return athletes.stream()
                .filter(a -> a.getDistance().equals(distance) && a.getGender().equals(gender))
                .sorted(Comparator.comparingInt(a -> convertTimeToSeconds(a.getTime())))
                .limit(n)
                .collect(Collectors.toList());
    }

    public int convertTimeToSeconds(String time) {
        String[] timeParts = time.split(":");
        int minutes = Integer.parseInt(timeParts[0]);
        int seconds = Integer.parseInt(timeParts[1]);
        return minutes * 60 + seconds;
    }
}
