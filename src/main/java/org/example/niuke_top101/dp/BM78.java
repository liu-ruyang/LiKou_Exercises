package org.example.niuke_top101.dp;

public class BM78 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int rob(int[] nums) {
        // write code here
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (i == 1) {
                dp[i] = nums[i - 1];
            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
            }
        }

        return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
    }
}
