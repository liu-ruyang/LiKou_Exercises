package org.example.niuke_top101.dp;

public class BM66 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * longest common substring
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String str1, String str2) {
        // write code here
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        index = i - 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        StringBuilder strBuilder = new StringBuilder();
        while (max > 0) {
            strBuilder.append(str1.charAt(index));
            max--;
            index--;
        }
        return strBuilder.reverse().toString();
    }
}
