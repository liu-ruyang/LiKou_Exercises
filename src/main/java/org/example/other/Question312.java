package org.example.other;

public class Question312 {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        return 0;
    }

    public int solve(int[] nums, int left, int right) {

        return 0;
    }
}
