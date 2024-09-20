package org.example.greedy_question;

import java.util.ArrayList;
import java.util.Arrays;

public class Question56 {
    public static void main(String[] args) {
        int[][] a = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        new Question56().merge(a);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> list = new ArrayList<>();

        int[] a = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {
                a[1] = Integer.max(a[1], intervals[i][1]);
                intervals[i][1] = a[1];
            } else {
                list.add(a);
                a = intervals[i];
            }
        }
        list.add(a);

        return list.toArray(new int[list.size()][]);
    }
}
