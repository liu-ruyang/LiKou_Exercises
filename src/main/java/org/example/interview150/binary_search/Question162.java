package org.example.interview150.binary_search;

/**
 * 我们首先在 [0,n) 的范围内随机一个初始位置 i，随后根据 nums[i−1],nums[i],nums[i+1] 三者的关系决定向哪个方向走：
 * 如果 nums[i−1]<nums[i]>nums[i+1]，那么位置 i 就是峰值位置，我们可以直接返回 i 作为答案；
 * 如果 nums[i−1]<nums[i]<nums[i+1]，那么位置 i 处于上坡，我们需要往右走，即 i←i+1；
 * 如果 nums[i−1]>nums[i]>nums[i+1]，那么位置 i 处于下坡，我们需要往左走，即 i←i−1；
 * 如果 nums[i−1]>nums[i]<nums[i+1]，那么位置 i 位于山谷，两侧都是上坡，我们可以朝任意方向走。
 */
public class Question162 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1};
        new Question162().findPeakElement(a);
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int left = 0, right = nums.length - 1;
        int res = binery_search(nums, left, right);
        if (res == -1) {
            res = nums[0] > nums[nums.length - 1] ? 0 : nums.length - 1;
        }
        return res;
    }

    public int binery_search(int[] nums, int left, int right) {
        if (right - left < 2) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            return mid;
        }

        int res = binery_search(nums, left, mid);
        if (res != -1) return res;
        res = binery_search(nums, mid, right);
        return res;
    }
}
