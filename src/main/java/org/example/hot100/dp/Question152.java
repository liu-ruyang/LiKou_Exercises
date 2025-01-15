package org.example.hot100.dp;

public class Question152 {
    // 方法一：分类讨论正负性（极不推荐，考虑的情况太复杂，非常易出错）
//    public int maxProduct(int[] nums) {
//        int[][] dp = new int[nums.length][2];   // dp[i][0] 记录到 i 位置截止的最小值，dp[i][1] 记录到 i 位置截止的最大值
//        dp[0][0] = nums[0];
//        dp[0][1] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                dp[i][0] = dp[i][1] = 0;
//            } else if (nums[i] > 0) {
//                if (dp[i - 1][1] > 0) {
//                    dp[i][1] = Math.max(dp[i - 1][1] * nums[i], nums[i]);
//                } else if (dp[i - 1][1] == 0) {
//                    dp[i][1] = Math.max(0, nums[i]);
//                } else if (dp[i - 1][1] < 0) {
//                    dp[i][1] = nums[i];
//                }
//
//                if (dp[i - 1][0] < 0) {
//                    dp[i][0] = dp[i - 1][0] * nums[i];
//                } else if (dp[i - 1][0] == 0) {
//                    dp[i][0] = Math.min(0, nums[i]);
//                } else if (dp[i - 1][0] > 0) {
//                    dp[i][0] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
//                }
//
//            } else if (nums[i] < 0) {
//
//                dp[i][0] = Math.min(nums[i], Math.min(nums[i] * dp[i - 1][0], nums[i] * dp[i - 1][1]));
//                dp[i][1] = Math.max(nums[i], Math.max(nums[i] * dp[i - 1][0], nums[i] * dp[i - 1][1]));
//
//            }
//        }
//    }

    // 方法二（推荐）：
    // ①每遍历到一个数值的时候，只记录到该位置的 最大乘积 和 最小乘积；
    // ②且 最大乘积 和 最小乘积 只会来源于三个数字：当前数字，当前数字与前一个最大乘积相乘，当前数字与前一个最小乘积相乘
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];   // dp[i][0] 记录到 i 位置截止的最小值，dp[i][1] 记录到 i 位置截止的最大值
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.min(nums[i], Math.min(nums[i] * dp[i - 1][0], nums[i] * dp[i - 1][1]));
            dp[i][1] = Math.max(nums[i], Math.max(nums[i] * dp[i - 1][0], nums[i] * dp[i - 1][1]));

            res = Math.max(dp[i][1], res);
        }
        return res;
    }
}
