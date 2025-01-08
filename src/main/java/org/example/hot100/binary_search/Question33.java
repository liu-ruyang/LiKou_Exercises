package org.example.hot100.binary_search;

public class Question33 {
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 0, 1, 2};
        new Question33().search(a, 0);
    }

    /**
     * 思路：先判断mid位置的元素在旋转数组的左部份还是右部分
     * 1.如果是在左部分，分两种情况：
     * ① 如果是比mid位置的元素大，则只需要将左边界向右移即可；
     * ② 如果是比mid位置的元素小，则可能是需要将右边界向左移，也可能是target不在左部分，而是在右部分（需要将左边界向右移）
     * 对应的处理方法：
     * ① 如果target比mid位置的元素小，且target确定在左部分，则将右边界向左移
     * ② 否则，左边界向右移（包括“target比mid位置的元素大”和“target在右部分”）
     * 2.如果是在右部分，分两种情况：
     * ① 如果是比mid位置的元素小，则只需要将右边界向左移即可；
     * ② 如果是比mid位置的元素大，则可能是需要将左边界向右移，也可能是target不在右部分，而是在左部分（需要将右边界向左移）
     * 对应的处理方法：
     * ① 如果target比mid位置的元素大，且target确定在右部分，则将左边界向右移
     * ② 否则，右边界向左移（包括“target比mid位置的元素小”和“target在左部分”）
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {     // 一定要是“<=”符号
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 先确定nums[mid]在左部分还是右部分
            if (nums[mid] <= nums[nums.length - 1]) {   // nums[mid]在右部分
                // target处于nums[mid]至nums[nums.length - 1]之间
                if (nums[mid] < target && target <= nums[nums.length - 1]) {        // 关键：比普通二分查找多了一个判断条件
                    left = mid + 1;
                } else {    // 包含情况：①target < nums[mid] ②虽然nums[mid] < target，但是target > nums[nums.length - 1]，即target在左部分
                    right = mid - 1;
                }
            } else {        // nums[mid]在左部分
                // target处于nums[0]至nums[mid]之间
                if (nums[mid] > target && target >= nums[0]) {    // 关键：比普通二分查找多了一个判断条件
                    right = mid - 1;
                } else {    // 包含情况：①target >= nums[mid] ②虽然nums[mid] > target，但是target < nums[0]，即target在右部分
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
