package com.athletics;

import com.athletics.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private ResultService resultService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        resultService.loadResults("src/main/resources/results.csv");
        resultService.getFastestRunners("10 км", "М", 5)
                .forEach(athlete -> System.out.println(athlete.getLastName()
                        + " " + athlete.getFirstName()
                        + " - " + athlete.getTime()));
    }
}
