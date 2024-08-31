package org.example.dp;

public class Question377 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        new Question377().combinationSum4(a, 4);
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 0;
        }
        dp[0] = 1;

        for (int i = 0; i < dp.length; i++) {
            for (int num : nums) {
                if (num <= i)
                    dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}
