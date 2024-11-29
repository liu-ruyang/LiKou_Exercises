package org.example.interview150.one_dim_dp;

import java.util.Arrays;

/**
 * 可以进行优化，维护一个数组d[i]，使d数组有序，d数组中元素来源于每次遍历的num数组元素
 * 如果遍历的num元素 > d 中当前下标所指元素，则添加进d中，并更新d中下标
 * 如果遍历的num元素 <= d 当钱下标所指元素，则二分查找d，将num当前遍历的元素插入其中，保持d有序，并将d中下标更新至该插入元素位置
 */
public class Question300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < dp.length; i++) {
            int j = i;
            while (j >= 0) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = res > dp[i] ? res : dp[i];
                }
                j--;
            }
        }
        return res;
    }
}
