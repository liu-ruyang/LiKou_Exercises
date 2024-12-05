package org.example.interview150.multi_dim_dp;

/**
 * 1. 确定dp数组以及下标含义
 * 2. 确定地推公式
 * 3. dp数组如何初始化
 * 4. 确定遍历顺序
 * 5. 举例推导dp数组
 */
public class Question97 {
    public static void main(String[] args) {
        new Question97().isInterleave("aabcc", "dbbca", "aadbbcbcac");
        // new Question97().isInterleave("a", "", "c");
    }

    // 滚动数组（逻辑有错误，待修正）
    // public boolean isInterleave(String s1, String s2, String s3) {
    //     int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
    //     if (len1 + len2 != len3) {
    //         return false;
    //     }
    //     boolean[] dp = new boolean[s2.length() + 1];
    //     dp[0] = true;
    //     for (int i = 0; i <= len1; i++) {
    //         for (int j = 0; j <= len2; j++) {
    //             if (j > 0) {
    //                 if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
    //                     dp[j] = dp[j - 1];
    //                 }
    //             }
    //             if (i > 0) {
    //                 if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
    //                     dp[j] = false;
    //                 }
    //             }
    //         }
    //     }
    //     return dp[len2];
    // }

    // 二维dp
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        if (len1 == 0 && s2.equals(s3) || len2 == 0 && s1.equals(s3)) {
            return true;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1]; // dp[i][j]表示可否使用下标0至i-1的s1 和下标0至j-1的s2 表示出下标0至i+j-1的s3
        dp[0][0] = true;
        for (int j = 1; j < dp[0].length; j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                dp[0][j] = true;
            } else break;
        }
        for (int i = 1; i < dp.length; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = true;
            } else break;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                // 下面这个if是核心：递推公式
                if (s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[i - 1][j] || s3.charAt(i + j - 1) == s2.charAt(j - 1) && dp[i][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
