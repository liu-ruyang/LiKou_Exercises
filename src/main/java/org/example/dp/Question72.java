package org.example.dp;

public class Question72 {
    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        dp[0][0] = 0;
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 不操作
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 增
                    // 删
                    // 换
                    // 操作一：word1删除一个元素，那么就是以下标i - 2为结尾的word1 与 j-1为结尾的word2的最近编辑距离 再加上一个操作。
                    // 操作二：word2删除一个元素，那么就是以下标i - 1为结尾的word1 与 j-2为结尾的word2的最近编辑距离 再加上一个操作。
                    // 替换元素，word1替换word1[i - 1]，使其与word2[j - 1]相同，此时不用增删加元素。
                    dp[i][j] = Integer.min(dp[i - 1][j - 1] + 1, Integer.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
