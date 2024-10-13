package org.example.interview150.interval;

import java.util.ArrayList;
import java.util.Arrays;

public class Question56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        ArrayList<int[]> res = new ArrayList<>();

        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (right < intervals[i][1]) {
                if (right >= intervals[i][0]) {
                    right = intervals[i][1];
                } else {
                    res.add(new int[]{left, right});
                    left = intervals[i][0];
                    right = intervals[i][1];
                }
            }
        }
        res.add(new int[]{left, right});
        
        return res.toArray(new int[res.size()][]);
//        return (int[][]) res.stream().toArray();
    }
}
