package org.example.review.skill;

import java.util.Arrays;

public class Question31 {
    // 两次遍历，第一次从后往前，找第一个左小于右的连续对；第二次从后往前，找第一个大于第一次找到的左边数
    // （原因：左边的数的右部分是单调递减的）
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int j = nums.length - 1; j >= 0; j--) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        Arrays.sort(nums, i, nums.length);
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }
    // public void nextPermutation(int[] nums) {
    //     int minIndex = nums.length - 1;
    //     int maxIndex = nums.length - 1;
    //     int dist = nums.length - 1;
    //
    //     for (int i = nums.length - 2; i >= 0; i--) {
    //         if ()
    //
    //     }
    // }
}
