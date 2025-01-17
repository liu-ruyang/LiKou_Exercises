package org.example.hot100.multi_dim_dp;

public class Question5 {
    public static void main(String[] args) {
//        new Question5().longestPalindrome("babad");
        new Question5().longestPalindrome("cbbd");
    }

    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];   // dp[i][j] 表示下标 i 至 j 的子串是否是回文子串
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }
        String res = String.valueOf(s.charAt(0));
        // 平行于主对角线 向右遍历
        for (int j = 1; j < dp.length; j++) {  // 列号（其实也是子串的长度-1）
            for (int i = 0; i < dp.length - j; i++) {   // 行号
                if (s.charAt(i) == s.charAt(i + j)) {
                    if (i + 1 == i + j)
                        dp[i][i + j] = 1;
                    else
                        dp[i][i + j] = dp[i + 1][i + j - 1];
                    if (dp[i][i + j] == 1) {
                        res = s.substring(i, i + j + 1);
                    }
                }
            }
        }
        return res;
    }
//    public String longestPalindrome(String s) {
//        int[][] dp = new int[s.length() + 1][s.length()];
//        Arrays.fill(dp[1], 1);
//
//        for (int i = 1; i <= dp.length; i++) {  // 寻找长度为 i 的回文子串
//            for (int j = 0; j < dp[i].length && j + 1 >= i; j++) {
//
//
//            }
//        }
//    }
}
