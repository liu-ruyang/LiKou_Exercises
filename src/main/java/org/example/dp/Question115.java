package org.example.dp;

public class Question115 {
    public int numDistinct(String s, String t) {

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= sChars.length; i++) {
            for (int j = 1; j <= tChars.length; j++) {
                if (sChars[i - 1] == tChars[j - 1]) {
                    // 当s[i - 1] 与 t[j - 1]相等时，dp[i][j]可以有两部分组成。
                    //      一部分是用s[i - 1]来匹配，那么个数为dp[i - 1][j - 1]。即不需要考虑当前s子串和t子串的最后一位字母，所以只需要 dp[i-1][j-1]。
                    //      一部分是不用s[i - 1]来匹配，个数为dp[i - 1][j]。
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[s.length()][t.length()];
    }
}
