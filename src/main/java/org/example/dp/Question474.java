package org.example.dp;

public class Question474 {

    /**
     * 1. 确定dp数组以及下标含义
     * 2. 确定地推公式
     * 3. dp数组如何初始化
     * 4. 确定遍历方式
     * 5. 举例推导dp数组
     *
     * @param args
     */

    public static void main(String[] args) {
        String[] a = {"10", "0", "1"};
        new Question474().findMaxForm(a, 1, 1);
    }

    // 计算某一个字符在字符串中出现的次数
    public static int countChar(String str, char ch) {
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        // 初始化
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = 0;
            }
        }
        for (String str : strs) {
            int zeroNum = countChar(str, '0');
            int oneNum = countChar(str, '1');

            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    if (zeroNum <= i && oneNum <= j) {
                        dp[i][j] = Integer.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
