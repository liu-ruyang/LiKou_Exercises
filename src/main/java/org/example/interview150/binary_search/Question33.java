package org.example.interview150.binary_search;

/**
 * 可以发现的是，我们将数组从中间分开成左右两部分的时候，一定 有一部分的数组是有序的
 * 这启示我们可以在常规二分查找的时候查看当前 mid 为分割位置分割出来的两个部分 [l, mid] 和 [mid + 1, r] 哪个部分是有序的，并根据有序的那个部分确定我们该如何改变二分查找的上下界，因为我们能够根据有序的那部分判断出 target 在不在这个部分
 * <p>
 */
public class Question33 {
    public int search(int[] nums, int target) {
        int res = binary_search(nums, target, 0, nums.length - 1);
        return res;
    }

    public int binary_search(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[left] >= nums[right]) {
            int leftRes = binary_search(nums, target, left, mid - 1);
            int rightRes = binary_search(nums, target, mid + 1, right);
            if (leftRes != -1) {
                return leftRes;
            }
            return rightRes;
        } else {
            if (nums[mid] > target) {
                int leftRes = binary_search(nums, target, left, mid - 1);
                return leftRes;
            } else {
                int rightRes = binary_search(nums, target, mid + 1, right);
                return rightRes;
            }
        }
    }
}
