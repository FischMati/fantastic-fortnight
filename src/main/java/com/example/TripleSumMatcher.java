package com.example;

import java.util.List;
import java.util.stream.Collectors;

public class TripleSumMatcher {
    public long distinctTripletSum(List<Long> a, List<Long> b, List<Long> c){
        List<Long> distinctA = a
            .stream()
            .distinct()
            .sorted()
            .collect(Collectors.toUnmodifiableList());

        List<Long> distinctB = b
            .stream()
            .distinct()
            .sorted()
            .collect(Collectors.toUnmodifiableList());

        List<Long> distinctC = c
            .stream()
            .distinct()
            .sorted()
            .collect(Collectors.toUnmodifiableList());

        int aIndex = 0;
        int cIndex = 0;
        long distinctTriplets = 0;

        for(int i = 0; i < distinctB.size(); i++){
            for(; aIndex < distinctA.size(); aIndex++){
                if(distinctA.get(aIndex) > distinctB.get(i)){
                    break;
                }
            }

            for(; cIndex < distinctC.size(); cIndex++){
                if(distinctC.get(cIndex) > distinctB.get(i)){
                    break;
                }
            }

            distinctTriplets += (long) aIndex * (long) cIndex;
        }

        

        return distinctTriplets;
    } 
}
