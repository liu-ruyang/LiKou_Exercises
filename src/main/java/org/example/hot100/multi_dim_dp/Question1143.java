package org.example.hot100.multi_dim_dp;

public class Question1143 {
    public static void main(String[] args) {
        new Question1143().longestCommonSubsequence("abcde", "ace");
    }

    // 先将字符串转换为字符数组
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
//                    dp[i][j] = Math.max(Math.max(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1] + 1);
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
    // 比较字符串字符时使用 String.charAt(i)
//    public int longestCommonSubsequence(String text1, String text2) {
//        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
//
//        for (int i = 1; i <= text1.length(); i++) {
//            for (int j = 1; j <= text2.length(); j++) {
//                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
//                    dp[i][j] = Math.max(Math.max(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1] + 1);
//                } else {
//                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
//                }
//            }
//        }
//
//        return dp[text1.length()][text2.length()];
//    }
}
