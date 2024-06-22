package org.example;

import java.util.Arrays;

public class Question2786 {
    /**
     * 1.确定dp数组以及下标含义
     * 2.确定递推公式
     * 3.dp数组如何初始化
     * 4.确定遍历顺序
     * 5.举例推导dp数组
     *
     * @param nums
     * @param x
     * @return
     */
    public static void main(String[] args) {
        // int[] a = {2, 3, 6, 1, 9, 2};
        // int[] a = {2, 4, 6, 8};
        int[] a = {9, 58, 17, 54, 91, 90, 32, 6, 13, 67, 24, 80, 8, 56, 29, 66, 85, 38, 45, 13, 20, 73, 16, 98, 28, 56, 23, 2, 47, 85, 11, 97, 72, 2, 28, 52, 33};
        // new Question2786().maxScore(a, 5);
        // new Question2786().maxScore(a, 3);
        new Question2786().maxScore(a, 90);
    }

    // public long maxScore(int[] nums, int x) {
    //     int[] dp = new int[nums.length];
    //     dp[0] = nums[0];
    //     for (int i = 1; i < nums.length; i++) {
    //         int result = 0;
    //         for (int j = 0; j < i; j++) {
    //             int temp = dp[j] + nums[i];
    //             if ((nums[i] + nums[j]) % 2 != 0) {
    //                 temp -= x;
    //             }
    //             if (result < temp)
    //                 result = temp;
    //         }
    //         dp[i] = result;
    //     }
    //     return dp[dp.length - 1];
    // }

    public long maxScore(int[] nums, int x) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // int result = 0;
            for (int j = 0; j < i; j++) {
                int temp = dp[j] + nums[i];
                if ((nums[i] + nums[j]) % 2 != 0) {
                    temp -= x;
                }
                if (dp[i] < temp)
                    dp[i] = temp;
            }
            // dp[i] = result;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
