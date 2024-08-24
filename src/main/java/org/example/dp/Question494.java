package org.example.dp;

import java.util.Arrays;

public class Question494 {
    public static void main(String[] args) {
        int[] a = {0, 0};
        int sumWays = new Question494().findTargetSumWays(a, 0);
        System.out.println(sumWays);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 != 0) {
            return 0;
        }
        int bigSize = (sum + target) / 2;
        if (bigSize < 0)
            return 0;

        // 确定dp数组及下标含义： dp[j] 表示：填满j（包括j）这么大容积的包，有dp[j]种方法
        int[] dp = new int[bigSize + 1];

        // 初始化dp数组
        // 本题的dp[0]必须要等于1，两种解释：
        // ①：不要硬去解释它的含义，咱就把 dp[0]的情况带入本题看看应该等于多少。
        // ②：在遍历到i号数字时，如果只靠单个i号数字即可满足目标和，那么应该有一种，此时组合是该i号数字和dp[0]组合，写入代码中，dp[0]就应该是1；
        // ③：注意点：一个数字都不选，也是作为一种情况考虑，更进一步说明dp[0]应该初始化为1
        dp[0] = 1; // 此处的dp[0]初始化意思是，还没开始选数字的时候。后面的遍历中第一次遇到的dp[0]赋值，表示的是通过选了某些数字使目标和为0

        // 遍历dp数组
        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= 0; j--) {
                if (nums[i] > j) {
                    break;
                } else {
                    dp[j] = dp[j] + dp[j - nums[i]];
                }
            }
        }
        return dp[bigSize];
    }
}
