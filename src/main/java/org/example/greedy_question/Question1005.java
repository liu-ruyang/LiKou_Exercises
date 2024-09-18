package org.example.greedy_question;

import java.util.Arrays;

public class Question1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        int sum = 0;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                count++;
            }
        }

        if (k <= count) {
            for (int i = 0; i < nums.length; i++) {
                if (i < k) {
                    sum += -nums[i];
                } else {
                    sum += nums[i];
                }
            }
        } else {
            k -= count;
            for (int i = 0; i < count; i++) {
                nums[i] = -nums[i];
            }
            Arrays.sort(nums);
            if (k%2!=0){
                nums[0] = -nums[0];
            }
            sum = Arrays.stream(nums).sum()
        }

        return sum;
    }
}
