package org.example.interview150.interval;

import java.util.ArrayList;

public class Question57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
//        Arrays.sort(intervals, (a, b) -> {
//            return a[0] - b[0];
//        });
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        ArrayList<int[]> res = new ArrayList<>();

//        int left = intervals[0][0];
//        int right = intervals[0][1];
        int left = 0;
        for (; left < intervals.length; left++) {
            if (intervals[left][1] < newInterval[0]) {
                res.add(intervals[left]);
            } else
                break;
        }

        if (intervals[left][0] > newInterval[1]) {
            res.add(newInterval);
        } else if (intervals[left][0] == newInterval[1]) {
            res.add(new int[]{newInterval[0], intervals[left][1]});
            left++;
        } else if (intervals[left][1] >= newInterval[1]) {
            int min = Integer.min(newInterval[0], intervals[left][0]);
            res.add(new int[]{min, intervals[left][1]});
            left++;
        } else if (intervals[left][1] < newInterval[1]) {
            int min = Integer.min(newInterval[0], intervals[left][0]);
            for (; left < intervals.length; left++) {
                if (intervals[left][0] > newInterval[1]) {
                    res.add(new int[]{min, newInterval[1]});
                    break;
                } else if (intervals[left][0] <= newInterval[1] && intervals[left][1] >= newInterval[1]) {
                    res.add(new int[]{min, intervals[left][1]});
                    left++;
                    break;
                }
            }
        }

        for (; left < intervals.length; left++) {
            res.add(intervals[left]);
        }


//        res.add(new int[]{left, right});

        return res.toArray(new int[res.size()][]);
//        return (int[][]) res.stream().toArray();

    }
}
