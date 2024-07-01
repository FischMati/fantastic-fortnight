package com.example;

import java.util.HashMap;
import java.util.Map;

public class StringAnagramDetector {
    public int anagramDiff(String a, String b){
        Map<Integer, Integer> charIntFrequencies = new HashMap<>();

        a
            .chars()
            .forEach(ci -> {
                charIntFrequencies.merge(ci, 1, Integer::sum);
            });

        b  
            .chars()
            .forEach(ci -> {
                charIntFrequencies.merge(ci, -1, Integer::sum);
            });


        return charIntFrequencies
            .values()
            .stream()
            .mapToInt(Math::abs)
            .sum();
    }
}
