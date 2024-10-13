package org.example.interview150.interval;

import java.util.ArrayList;
import java.util.Arrays;

public class Question57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> nums = new ArrayList<>();
        for (int[] interval : intervals) {
            nums.add(interval);
        }
        nums.add(newInterval);
        int[][] array = nums.toArray(new int[nums.size()][]);


        Arrays.sort(array, (a, b) -> {
            return a[0] - b[0];
        });

        ArrayList<int[]> res = new ArrayList<>();

        int left = array[0][0];
        int right = array[0][1];
        for (int i = 1; i < array.length; i++) {
            if (right < array[i][1]) {
                if (right >= array[i][0]) {
                    right = array[i][1];
                } else {
                    res.add(new int[]{left, right});
                    left = array[i][0];
                    right = array[i][1];
                }
            }
        }
        res.add(new int[]{left, right});

        return res.toArray(new int[res.size()][]);
    }
}
