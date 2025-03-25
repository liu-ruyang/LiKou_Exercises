package org.example.other;

public class Question34 {
    public static void main(String[] args) {
        // int[] a = {5, 7, 7, 8, 8, 10};
        int[] a = {};
        new Question34().searchRange(a, 0);
    }

    public int[] searchRange2(int[] nums, int target) {
        int littlerIndex = searchFirstLittler(nums, target);
        int largerIndex = searchFirstLarger(nums, target);

        if (littlerIndex == -1 && largerIndex == -1) {
            if (nums.length == 0) {
                return new int[]{-1, -1};
            }
            return new int[]{0, nums.length - 1};
        } else if (littlerIndex == -1) {
            if (largerIndex == 0) {
                return new int[]{-1, -1};
            } else {
                return new int[]{0, largerIndex - 1};
            }
        } else if (largerIndex == -1) {
            if (littlerIndex == nums.length - 1) {
                return new int[]{-1, -1};
            } else {
                return new int[]{littlerIndex + 1, nums.length - 1};
            }
        } else {
            if (littlerIndex + 1 == largerIndex) {
                return new int[]{-1, -1};
            } else {
                return new int[]{littlerIndex + 1, largerIndex - 1};
            }
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int leftIndex = searchFirstNotLittler(nums, target);
        int rightIdnex = searchFirstNotLarger(nums, target);

        if (leftIndex == -1 || rightIdnex == -1) {
            return new int[]{-1, -1};
        } else {
            if (leftIndex > rightIdnex) {
                return new int[]{-1, -1};
            } else {
                return new int[]{leftIndex, rightIdnex};
            }
        }
    }


    // 寻找第一个 >= target
    public int searchFirstNotLittler(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {    // nums[mid] >= target
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    // 寻找第一个 <= target
    public int searchFirstNotLarger(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {    // nums[mid] <= target
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }

    public int searchFirstLittler(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {  // && nums[mid] < target
                if (mid == nums.length - 1 || nums[mid + 1] >= target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;  // 没找到小于 target 的数
    }

    // 寻找第一个大于 target
    public int searchFirstLarger(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else { // nums[mid] > target
                if (mid == 0 || nums[mid - 1] <= target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
