package org.example.other;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int maximizeSum = new Solution2().maximizeSum(nums, 3);
        System.out.println(maximizeSum);
    }

    public int maximizeSum(int[] nums, int k) {
        int result = 0;
        sort(nums);

        while (k != 0) {
            result += nums[nums.length - 1];
            nums[nums.length - 1] = nums[nums.length - 1] + 1;
            k--;
        }
        return result;
    }

    public void sort(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
