package org.example.greedy_question;

public class Question53 {
    // 贪心算法：
    // 局部最优：当前“连续和”为负数的时候立刻放弃，从下一个元素重新计算“连续和”，因为负数加上下一个元素 “连续和”只会越来越小。
    // 全局最优：选取最大“连续和”
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int temp = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (temp > 0) {
                temp += nums[i];
            } else {
                temp = nums[i];
            }

            result = temp > result ? temp : result;
        }

        return result;
    }
}
