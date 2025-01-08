package org.example.hot100.binary_search;

public class Question34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                left = right = mid;
                res[0] = left;
                res[1] = right;
                while (left >= 0 && nums[left] == target) {
                    res[0] = left;
                    left--;
                }
                while (right < nums.length && nums[right] == target) {
                    res[1] = right;
                    right++;
                }
                return res;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
//    public int[] searchRange(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//        int[] res = {-1, -1};
//        // 寻找第一个小于target的元素
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (nums[mid] < target) {
//                left = mid + 1;
//            } else if (nums[mid] >= target) {
//                right = mid - 1;
//            }
//        }
//        if (right == -1 || left == nums.length) {
//            res[0] = -1;
//            res[1] = -1;
//            return res;
//        }
//        res[0] = left;
//        // 寻找第一个大于target的元素
//        left = 0;
//        right = nums.length - 1;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (nums[mid] <= target) {
//                left = mid + 1;
//            } else if (nums[mid] > target) {
//                right = mid - 1;
//            }
//        }
//        if (right == -1) {
//            res[0] = -1;
//
//        }
//        res[0] = right;
//    }
}
