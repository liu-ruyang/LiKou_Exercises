package org.example;

import java.util.Scanner;

public class KaMaWang57 {
    /**
     * 1. 确定dp数组以及下标含义
     * 2. 确定递推公式
     * 3. dp数组如何初始化
     * 4. 确定遍历顺序
     * 5. 举例推导dp数组
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(" ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= m; j++) {
                if (i - j >= 0) {
                    dp[i] += dp[i - j];
                }
            }
        }
        System.out.print(dp[n]);
    }
}
