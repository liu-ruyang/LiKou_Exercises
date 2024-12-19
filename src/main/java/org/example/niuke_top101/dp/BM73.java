package org.example.niuke_top101.dp;

public class BM73 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param A string字符串
     * @return int整型
     */
    public int getLongestPalindrome(String A) {
        // write code here
        int[][] dp = new int[A.length()][A.length()];
        int res = 0;
        for (int i = 0; i < A.length(); i++) {
            dp[i][i] = 1;
            res = Math.max(res, dp[i][i]);
        }

        // 从字符串角度思考i和j的取值比较容易
        for (int j = 1; j < A.length(); j++) {  // j是字串右边界
            for (int i = j - 1; i >= 0; i--) { // i是字串左边界
                if (i == j - 1 && A.charAt(i) == A.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], 2);
                } else if (A.charAt(i) == A.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] == 0 ? 0 : dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = 0;
                }
                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }
}
