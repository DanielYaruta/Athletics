package com.athletics.service;

import com.athletics.processor.ResultsProcessor;
import com.athletics.model.Athlete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ResultService {
    @Autowired
    private ResultsProcessor resultsProcessor;

    public void loadResults(String filePath) throws IOException {
        resultsProcessor.loadResults(filePath);
    }

    public List<Athlete> getFastestRunners(String distance, String gender, int n) {
        return resultsProcessor.getFastestRunners(distance, gender, n);
    }
}