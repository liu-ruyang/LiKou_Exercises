package org.example.niuke_top101.dp;

import java.util.Arrays;

public class BM71 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 给定数组的最长严格上升子序列的长度。
     *
     * @param arr int整型一维数组 给定的数组
     * @return int整型
     */
    public int LIS(int[] arr) {
        // write code here
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        int res = 0;
        for (int i = 1; i <= arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (j == 0) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                } else if (arr[i - 1] > arr[j - 1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                res = res < dp[i] ? dp[i] : res;
            }
        }

        return res;
    }
}
