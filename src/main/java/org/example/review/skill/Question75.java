package org.example.review.skill;

public class Question75 {
    int left;
    int right;

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new Question75().sortColors(nums);
    }

    public void sortColors(int[] nums) {
        left = 0;
        right = nums.length - 1;
        adjust(nums);
        for (int i = left; i <= right; ) {
            if (nums[i] == 2) {
                int temp = nums[right];
                nums[right] = nums[i];
                nums[i] = temp;
            }
            if (nums[i] == 0) {
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
            }
            adjust(nums);
            i++;
            i = Math.max(i, left);
        }
    }

    public void adjust(int[] nums) {
        if (left >= right) {
            return;
        }
        while (left < right && nums[left] == 0) {
            left++;
        }
        while (left < right && nums[right] == 2) {
            right--;
        }
    }
}
