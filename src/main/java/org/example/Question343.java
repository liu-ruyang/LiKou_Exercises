package org.example;

public class Question343 {
    /**
     * 1.确定dp数组以及下标含义
     * 2.确定递推公式
     * 3.dp数组如何初始化
     * 4.确定dp数组遍历方式
     * 5.举例推导dp数组
     *
     * @param n
     * @return
     */

    public static void main(String[] args) {
        new Question343().integerBreak(10);
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int temp = 1;
            for (int j = 2; j <= i - 1; j++) {
                int num = Math.max(j * (i - j), j * dp[i - j]);
                temp = temp > num ? temp : num;

            }
            dp[i] = temp;
        }
        return dp[n];
    }


    // 不知道为啥正确，但是耗时更短更高
    // public int integerBreak(int n) {
    //     int[] dp = new int[n + 1];
    //     dp[2] = 1;
    //     dp[1] = 1;
    //     if (n == 3) {
    //         return 2;
    //     }
    //     for (int i = 3; i <= n; i++) {
    //         int temp = 1;
    //         for (int j = 2; j <= i - 1; j++) {
    //             int num = j * dp[i - j];
    //             temp = temp > num ? temp : num;
    //             temp = temp > i ? temp : i;
    //
    //         }
    //         dp[i] = temp;
    //     }
    //     return dp[n];
    // }
}
