package org.example.hot100.binary_search;

public class Question153 {
    public static void main(String[] args) {
//        int[] a = {11, 13, 15, 17};
        int[] a = {2, 1};
        new Question153().findMin(a);
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1] || mid == 0 && nums[0] <= nums[nums.length - 1]) {
                return nums[mid];
            }
            // 在左部分
            if (nums[mid] >= nums[nums.length - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
