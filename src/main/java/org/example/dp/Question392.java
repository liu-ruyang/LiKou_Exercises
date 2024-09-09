package org.example.dp;

public class Question392 {
    public static void main(String[] args) {
        new Question392().isSubsequence("abc", "ahbgdc");
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length())
            return false;


        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        int max = 0;
        for (int i = 1; i <= sChars.length; i++) {
            for (int j = 1; j <= tChars.length; j++) {
                if (sChars[i - 1] == tChars[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 和 1143.最长公共子序列 (opens new window)的递推公式基本那就是一样的，区别就是 本题 如果删元素一定是字符串t，而 1143.最长公共子序列 是两个字符串都可以删元素
                    // dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = dp[i][j - 1];
                }
                max = dp[i][j] > max ? dp[i][j] : max;
            }
        }

        return max == s.length();
    }
}
