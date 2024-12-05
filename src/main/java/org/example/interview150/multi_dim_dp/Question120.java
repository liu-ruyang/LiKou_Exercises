package org.example.interview150.multi_dim_dp;

import java.util.Arrays;
import java.util.List;

public class Question120 {
    public static void main(String[] args) {
        new Question120().minimumTotal(Arrays.asList(List.of(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3)));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < dp.length; i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + list.get(j);
                } else {
                    dp[i][j] = dp[i - 1][j] + list.get(j);
                }
            }
        }

        return Arrays.stream(dp[dp.length - 1]).min().getAsInt();
    }
}
