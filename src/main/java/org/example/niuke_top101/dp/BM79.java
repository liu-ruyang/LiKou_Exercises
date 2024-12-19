package org.example.niuke_top101.dp;

public class BM79 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int rob(int[] nums) {
        // write code here
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length + 1];

        dp1[0] = 0;
        dp2[1] = 0;

        int res = Integer.MIN_VALUE;

        for (int i = 1; i < dp1.length; i++) {
            if (i == 1) {
                dp1[i] = nums[i - 1];
            } else {
                dp1[i] = Math.max(dp1[i - 2] + nums[i - 1], dp1[i - 1]);
            }
            res = Math.max(res, dp1[i]);
        }

        for (int i = 2; i < dp2.length; i++) {
            if (i == 2) {
                dp2[i] = nums[i - 1];
            } else {
                dp2[i] = Math.max(dp2[i - 2] + nums[i - 1], dp2[i - 1]);
            }
            res = Math.max(res, dp2[i]);
        }

        return res;
    }
}
