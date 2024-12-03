package org.example.interview150.mulyi_dim_dp;

public class Question5 {
    public static void main(String[] args) {
        // new Question5().longestPalindrome("aacabdkacaa");
        new Question5().longestPalindrome("aa");
    }

    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];   // dp[i][j]表示下标i至j的字符串是否是回文串，1表示是，2表示不是
        String res = "";

        // 遍历主对角线及其上方的斜线
        for (int d = 0; d < dp[0].length; d++) {
            for (int offset = 0; d + offset < dp.length; offset++) {    // 终止条件：列号不能溢出
                int i = offset;
                int j = d + offset;

                if (s.charAt(i) == s.charAt(j)) {   // 两字母相等
                    if (i == j) {       // 如果是单个字母一定满足
                        if (res.length() < j - i + 1) {
                            res = s.substring(i, j + 1);
                        }
                        dp[i][j] = 1;
                    } else if (i == j - 1) {    // 如果是相邻两个字母一定满足
                        if (res.length() < j - i + 1) {
                            res = s.substring(i, j + 1);
                        }
                        dp[i][j] = 1;
                    } else {    // 如果是其他情况，需要判断中间字符串是否也是回文串
                        if (dp[i + 1][j - 1] == 1) {    // 中间字母是回文串
                            dp[i][j] = 1;
                            if (res.length() < j - i + 1) {     // 需要更新返回的结果
                                res = s.substring(i, j + 1);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
