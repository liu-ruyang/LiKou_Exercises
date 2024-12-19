package org.example.niuke_top101.dp;

import java.util.Arrays;

public class BM70 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 最少货币数
     *
     * @param arr int整型一维数组 the array
     * @param aim int整型 the target
     * @return int整型
     */
    public int minMoney(int[] arr, int aim) {
        // write code here
        int[] dp = new int[aim + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= aim; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] <= i && dp[i - arr[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }

        return dp[aim] == Integer.MAX_VALUE ? -1 : dp[aim];
    }
}
