package org.example.hot100.dp;

import java.util.Arrays;

public class Question300 {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 2, 3};
        new Question300().lengthOfLIS(a);
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int res = 1;

        for (int i = 0; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }

        return res;
    }
}
