package org.example;

public class Question518 {
    public static void main(String[] args) {
        int[] a = {1, 2, 5};
        new Question518().change(0, a);
    }

    /**
     * 1. 确定dp数组以及下标含义
     * 2. 确定递推公式
     * 3. dp数组如何初始化
     * 4. 确定遍历顺序
     * 5. 举例推导dp数组
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];

        // 初始化
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 0;
        }
        dp[0] = 1;      // 组合数的问题，都会隐藏一个条件，就是总额为0的时候，无论如何都有一种选法，即什么都不选

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }

        // 上述做法不会重复计算不同的排列。因为外层循环是遍历数组 coins 的值，内层循环是遍历不同的金额之和，
        // 在计算 dp[i] 的值时，可以确保金额之和等于 i 的硬币面额的顺序，由于顺序确定，因此不会重复计算不同的排列。

        return dp[amount];
    }
}
