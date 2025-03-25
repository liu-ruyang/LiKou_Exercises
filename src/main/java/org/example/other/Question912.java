package org.example.other;

/**
 * 快速排序
 */
public class Question912 {
    public static void main(String[] args) {
        // int[] a = {5, 2, 3, 1};
        int[] a = {5, 1, 1, 2, 0, 0};
        new Question912().sortArray(a);
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int l = left;
        int r = right;
        int key = left;
        while (left < right) {
            // 从右边先开始，找到第一个小于 nums[key] 的停下
            while (nums[right] >= nums[key] && left < right) {
                right--;
            }
            // left右移，找到第一个大于 nums[key] 的停下
            while (nums[left] <= nums[key] && left < right) {
                left++;
            }

            swap(nums, left, right);
        }

        swap(nums, left, key);
        quickSort(nums, l, left - 1);
        quickSort(nums, left + 1, r);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
