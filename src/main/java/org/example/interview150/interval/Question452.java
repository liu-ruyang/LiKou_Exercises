package org.example.interview150.interval;

import java.util.Arrays;

public class Question452 {
    public static void main(String[] args) {
        int[][] a = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        // int[][] b = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] b = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        // new Question452().findMinArrowShots(a);
        new Question452().findMinArrowShots(b);
    }

    public int findMinArrowShots(int[][] points) {
        // Arrays.sort(points, (a, b) -> a[0] - b[0]);
        Arrays.sort(points, (a, b) -> {
            if (a[0] > b[0]) {
                return 1;
            } else if (a[0] < b[0]) {
                return -1;
            }
            return 0;
        });

        int res = 1;
        int left = points[0][0];
        int right = points[0][1];

        for (int i = 1; i < points.length; i++) {

            // if (points[i][0] > points[i - 1][1]) {
            //     res++;
            // } else {
            //     points[i][1] = Integer.min(points[i][1], points[i - 1][1]);
            // }
            if (points[i][0] > right) {
                res++;
                left = points[i][0];
                right = points[i][1];
            } else if (points[i][1] < left) {
                res++;
                left = points[i][0];
                right = points[i][0];
            } else {
                left = Integer.max(points[i][0], left);
                right = Integer.min(points[i][1], right);
            }
        }

        return res;
    }
}
