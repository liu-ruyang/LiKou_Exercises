package org.example.hot100.dp;

public class Question198 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[][] dp = new int[nums.length][2];   // dp[i][0] 表示不拿第i间屋子的，dp[i][1] 表示拿第i间屋子的
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        dp[1][0] = dp[0][1];
        dp[1][1] = nums[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }
}
