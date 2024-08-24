package org.example.dp;

public class Question213 {
    /**
     * 1. 确定dp数组及下标含义
     * 2. 确定递推公式
     * 3. dp数组如何初始化
     * 4. 确定遍历顺序
     * 5. 举例推导dp数组
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        int[] dp2 = new int[nums.length + 1];
        dp2[1] = 0;
        dp2[2] = nums[1];
        for (int i = 3; i <= nums.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i - 1]);
        }
        return Math.max(dp[nums.length - 1], dp2[nums.length]);
    }
}
