package com.athletics.processor;

import com.athletics.model.Athlete;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

public class ResultsProcessorTest {
    private ResultsProcessor resultsProcessor;

    @BeforeEach
    public void setUp() {
        resultsProcessor = new ResultsProcessor();
    }

    @Test
    public void testLoadResults() throws IOException {
        resultsProcessor.loadResults("src/main/resources/results.csv");

        int count = resultsProcessor.getFastestRunners("10 км", "М", 10).size();

        assertEquals(6, count);
    }

    @Test
    public void testGetFastestRunners() throws IOException {
        resultsProcessor.loadResults("src/main/resources/results.csv");

        List<Athlete> fastestRunners = resultsProcessor.getFastestRunners("10 км", "М", 5);

        fastestRunners.forEach(a ->
                System.out.println(a.getLastName() + " " + a.getFirstName() + " - " + a.getTime()));

        assertEquals(5, fastestRunners.size());
    }
}