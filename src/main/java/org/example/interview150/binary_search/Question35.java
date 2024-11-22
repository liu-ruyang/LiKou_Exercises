package org.example.interview150.binary_search;

public class Question35 {
    public static void main(String[] args) {
        int[] a = {1, 3};
        new Question35().searchInsert(a, 4);
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (nums[left] == target) {
            return left;
        }
        return nums[left] > target ? left - 1 : left + 1;
    }
}
