package org.example.niuke_top101.dp;

public class BM65 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * longest common subsequence
     *
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String s1, String s2) {
        // write code here
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < s2.length(); j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        if (dp[s1.length()][s2.length()] == 0) return "-1";

        StringBuilder strbuilder = new StringBuilder();
        int i = s1.length(), j = s2.length();
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i][j - 1]) {
                j--;
            } else if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else if (dp[i][j] == dp[i - 1][j - 1] + 1) {
                strbuilder.append(s1.charAt(i - 1));
                i--;
                j--;
            }
        }
        return strbuilder.reverse().toString();
    }
}
