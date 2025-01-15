package org.example.hot100.dp;

import java.util.Arrays;

public class Question416 {
    public static void main(String[] args) {
        int[] a = {2, 2, 1, 1};
        new Question416().canPartition(a);
    }

    // 01背包的一维数组实现中，要先遍历物品，再遍历容量，且第二层是从大到小遍历
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= 0; j--) {
                if (j >= nums[i])
                    dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[target];
    }
}
