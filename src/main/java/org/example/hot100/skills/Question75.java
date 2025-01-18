package org.example.hot100.skills;

public class Question75 {
    public static void main(String[] args) {
//        int[] a = {2, 0, 2, 1, 1, 0};
//        int[] a = {2, 1, 2};
        int[] a = {0, 2, 2, 2, 0, 2, 1, 1};
        new Question75().sortColors(a);
    }

    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        left = findFirstLeft(nums, left);
        right = findFirstRight(nums, right);

        for (int i = left; i <= right; ) {
            if (nums[i] == 0) {
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left = findFirstLeft(nums, left);
                if (i < left) i = left;
                if (nums[i] == 2) {
                    temp = nums[right];
                    nums[right] = nums[i];
                    nums[i] = temp;
                    right = findFirstRight(nums, right);
                }
            } else if (nums[i] == 2) {
                int temp = nums[right];
                nums[right] = nums[i];
                nums[i] = temp;
                right = findFirstRight(nums, right);
                if (nums[i] == 0) {
                    temp = nums[left];
                    nums[left] = nums[i];
                    nums[i] = temp;
                    left = findFirstLeft(nums, left);
                    if (i < left) i = left;
                }
            } else {
                i++;
            }
        }
    }

    public int findFirstLeft(int[] nums, int left) {
        while (nums[left] == 0) {
            left++;
        }
        return left;
    }

    public int findFirstRight(int[] nums, int right) {
        while (nums[right] == 2) {
            right--;
        }
        return right;
    }
}
