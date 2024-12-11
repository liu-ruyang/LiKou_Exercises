package org.example.niuke_top101.binery_seaerch_and_sort;

public class BM21 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int minNumberInRotateArray(int[] nums) {
        // write code here
        if (nums.length == 1) return nums[0];
        if (nums[0] < nums[nums.length - 1]) return nums[0];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
            else if (nums[mid] > nums[0])
                left = mid + 1;        // 如果想要简化代码，就不应该和左边界比较，而是和右边界比较，因为上面的整除2会导致mid和left一样，从而忽略了right的位置
            else if (nums[mid] < nums[0]) right = mid - 1;
            else if (nums[mid] == nums[0]) right--;      // 如果一样，就缩小一下右边界
        }
        return nums[left];
    }
}
