package org.example.hot100.dp;

import java.util.Arrays;

public class Question279 {
    public static void main(String[] args) {
//        new Question279().numSquares(12);
        new Question279().numSquares(2);
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
//                if (j * j == i) {
//                    dp[i] = 1;
//                    break;
//                } else {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
//                }
            }
        }

        return dp[n];
    }

//    public int numSquares(int n) {
//        int[] dp = new int[n + 1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[1] = 1;
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j < i; j++) {
//                if (j * j == i) {
//                    dp[i] = 1;
//                    break;
//                } else {
//                    dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
//                }
//            }
//        }
//
//        return dp[n];
//    }
}
