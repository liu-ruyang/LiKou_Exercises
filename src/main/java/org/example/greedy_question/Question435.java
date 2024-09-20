package org.example.greedy_question;

import java.util.Arrays;

public class Question435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                count++;
                intervals[i][1] = Integer.min(intervals[i][1], intervals[i - 1][1]);
            }
        }
        return count;
    }
}
