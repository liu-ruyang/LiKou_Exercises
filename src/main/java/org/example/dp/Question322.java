package org.example.dp;

public class Question322 {
    public static void main(String[] args) {
        int a[] = {1, 2, 5};
        new Question322().coinChange(a, 11);
    }

    /**
     * 1. 确定dp数组及下标含义
     * 2. 确定递推公式
     * 3. dp数组如何初始化（根据dp数组及下标定义确定）
     * 4. dp数组如何遍历
     * 5. 举例推导dp数组
     *
     * @param coins
     * @param amount
     * @return
     */

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE)      // 防止内存溢出
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

//        int[][] dp = new int[coins.length][amount + 1];
//        for (int i = 0; i < dp[0].length; i++) {
//            if (coins[0] <= i) {
//                dp[0][i] = 1;
//            }
//        }
//        for (int i = 0; i < coins.length; i++) {
//            dp[i][0] = 1;
//        }
//
//
//        int count[] = new int[amount + 1];
//
//        for (int i = 1; i < coins.length; i++) {
//            for (int j = coins[i]; j < dp.length; j++) {
//                if (dp[i - 1][j] > dp[i - 1][j - coins[i]] + coins[i]) {
//                    dp[i][j] = dp[i - 1][j];
//                } else if (dp[i - 1][j] < dp[i - 1][j - coins[i]] + coins[i]) {
//                    dp[i][j] = dp[i - 1][j - coins[i]] + coins[i];
//                    count[j] = count[j - coins[i]] + 1;
//                } else {
//                    dp[i][j] = dp[i - 1][j - coins[i]] + coins[i];
//                    count[j] = Integer.min(count[j], count[j - coins[i]] + 1);
//                }
//            }
//        }
//
//
//        return count[amount] == 0 ? -1 : count[amount];

    }
}
