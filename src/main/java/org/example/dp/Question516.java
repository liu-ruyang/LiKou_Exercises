package org.example.dp;

public class Question516 {
    public static void main(String[] args) {
        new Question516().longestPalindromeSubseq("bbbab");
    }

    public int longestPalindromeSubseq(String s) {

        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                // if (i == j || j - i == 1) {
                //     dp[i][j] = j - i + 1;
                // } else {
                //     if (s.charAt(i) == s.charAt(j)) {
                //         dp[i][j] = dp[i + 1][j - 1] + 2;
                //     } else {
                //         dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                //     }
                // }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                } else {
                    if (i == j || j - i == 1) {
                        dp[i][j] = j - i + 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                }
                // if (j == i) {
                //     dp[i][j] = 1;
                // }
            }
        }
        return dp[0][s.length() - 1];
    }
}
