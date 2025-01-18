package org.example.hot100.skills;

import java.util.Arrays;

public class Question31 {
    public static void main(String[] args) {
//        int[] a = {2, 3, 1};
        int[] a = {4, 2, 0, 2, 3, 2, 0};
        new Question31().nextPermutation(a);
    }

    // 两次遍历，第一次从后往前，找第一个左小于右的连续对；第二次从后往前，找第一个大于第一次找到的左边数
    public void nextPermutation(int[] nums) {
        for (int j = nums.length - 2; j >= 0; j--) {
            for (int i = nums.length - 1; i > j; i--) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    Arrays.sort(nums, j + 1, nums.length);
                    return;
                }
            }
        }
        // 升序排序
        Arrays.sort(nums);
    }
}
