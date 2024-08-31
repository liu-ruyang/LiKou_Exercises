package org.example.other;

import java.util.ArrayList;
import java.util.List;

public class Question2951 {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> integers = new ArrayList<>();

        if (mountain.length < 3)
            return integers;

        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                integers.add(i);
            }
        }
        return integers;
    }
}
