package org.example.niuke_top101.binery_seaerch_and_sort;

public class BM19 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int findPeakElement(int[] nums) {
        // write code here
        if (nums.length == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
        int left = 1, right = nums.length - 2;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            else if (nums[mid] < nums[mid - 1]) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}
