package org.example.interview150.binary_search;

public class Question34 {
    public int[] searchRange(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int mid = (left + right) / 2;

        while (left <= right && nums[mid] != target) {
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }

        int[] res = {-1, -1};
        if (left > right) {
            return res;
        }

        left = right = mid;
        while (left > 0 && nums[left - 1] == nums[left]) {
            left--;
        }
        while (right < nums.length - 1 && nums[right + 1] == nums[right]) {
            right++;
        }
        res[0] = left;
        res[1] = right;

        return res;
    }

}
