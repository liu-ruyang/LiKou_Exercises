package org.example.hot100.multi_dim_dp;

public class Question72 {
    public static void main(String[] args) {
        new Question72().minDistance("intention", "execution");
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = i;
        for (int j = 0; j < dp[0].length; j++)
            dp[0][j] = j;

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
