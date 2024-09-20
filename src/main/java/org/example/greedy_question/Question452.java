package org.example.greedy_question;

import java.util.Arrays;

public class Question452 {
    public static void main(String[] args) {
        int[][] a = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        new Question452().findMinArrowShots(a);
    }

    public int findMinArrowShots(int[][] points) {
        // Arrays.sort(points, (a, b) -> a[0] - b[0]);     // 升序排序（会有溢出，导致极端数值出错）
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 1;

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {
                count++;
            } else {
                points[i][1] = Integer.min(points[i - 1][1], points[i][1]);
            }
        }
        return count;
    }
}