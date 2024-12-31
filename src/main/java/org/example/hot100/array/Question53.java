package org.example.hot100.array;

import java.util.Arrays;

public class Question53 {
    // 动态规划
    // 递推公式
    // dp[i]只有两个方向可以推出来：
    // dp[i - 1] + nums[i]，即：nums[i]加入当前连续子序列和
    // nums[i]，即：从头开始计算当前连续子序列和
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];

        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            if (res < dp[i]) res = dp[i];
        }
        return res;
    }
}
