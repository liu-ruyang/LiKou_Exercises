package org.example.dp;

import java.util.Arrays;

public class Question416 {
    public static void main(String[] args) {
//        int[] a = {1, 5, 11, 5};
        int[] a = {9, 1, 2, 4, 10};
        new Question416().canPartition(a);
    }

    /*
    1. 确定dp数组及其下标含义
    2. 确定递推公式
    3. dp数组如何初始化
    4. 确定遍历顺序
    5. 举例推导dp数组
     */
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        // 集合之和为奇数
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        // 一行代表一个数字，一列代表一个总和
        int rows = nums.length;
        int cols = target + 1;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < cols; j++) {
            if (dp[0][j] >= nums[0]) {
                dp[0][j] = nums[0];
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (j - nums[i] >= 0 && dp[i - 1][j - nums[i]] + nums[i] <= j)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        if (dp[rows - 1][cols - 1] == target)
            return true;
        return false;

    }
}
