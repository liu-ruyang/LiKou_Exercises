package org.example.greedy_question;

public class Question53 {
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
