package org.example.dp;

public class Question583 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = max > dp[i][j] ? max : dp[i][j];
                } else {
                    dp[i][j] = Integer.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return word1.length() + word2.length() - max - max;
    }
}
