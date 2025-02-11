package org.example.review.dp;

public class Question516 {
    public static void main(String[] args) {
        new Question516().longestPalindromeSubseq("abcabcabcabc");
    }

    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        int res = dp[0][0];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < dp[i].length; j++) {
                if (j - i == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }
}
