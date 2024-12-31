package org.example.hot100.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question56 {
    // 贪心
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            return Integer.compare(o1[0], o2[0]);
        });

        int left = intervals[0][0];
        int right = intervals[0][1];

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= right && intervals[i][1] > right) {
                right = intervals[i][1];
            } else if (intervals[i][0] > right) {
                list.add(Arrays.asList(left, right));
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }

        list.add(Arrays.asList(left, right));

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i).get(0);
            res[i][1] = list.get(i).get(1);
        }

        return res;
    }
}
