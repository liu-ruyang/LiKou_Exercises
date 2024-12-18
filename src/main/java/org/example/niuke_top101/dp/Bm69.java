package org.example.niuke_top101.dp;

/**
 * 对于普通数组1-9，译码方式只有一种，但是对于11-19，21-26，译码方式有可选择的两种方案，因此我们使用动态规划将两种方案累计。
 */
public class Bm69 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 解码
     *
     * @param nums string字符串 数字串
     * @return int整型
     */
    public int solve(String nums) {
        // write code here
        if (nums.length() == 1 && nums.equals("0")) return 0;
        int[] dp = new int[nums.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= nums.length(); i++) {
            if (nums.charAt(i - 1) == '0') {
                if (i > 1 && nums.charAt(i - 2) != '1' && nums.charAt(i - 2) != '2') {
                    return 0;
                }
                dp[i] = dp[i - 1];
            } else if (nums.charAt(i - 1) >= '1' && nums.charAt(i - 1) <= '6') {
                if (i > 1 && (nums.charAt(i - 2) == '1' || nums.charAt(i - 2) == '2')) {
                    // dp[i] = dp[i - 1] + 1;
                    dp[i] = dp[i - 2] + dp[i - 1];
                } else {
                    dp[i] = dp[i - 1];
                }
            } else {
                if ((i > 1 && nums.charAt(i - 2) == '1')) {
                    // dp[i] = dp[i - 1] + 1;
                    dp[i] = dp[i - 2] + dp[i - 1];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[nums.length()];
    }
}
