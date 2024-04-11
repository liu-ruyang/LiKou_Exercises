package org.example;

public class Solution3 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxLength = 0;
        int tempLength = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                tempLength++;
                while ((i + 1 < nums.length) && (nums[i] % 2 != nums[i + 1] % 2) && (nums[i] <= threshold && nums[i + 1] <= threshold)) {
                    i++;
                    tempLength++;
                }

                if (maxLength < tempLength) {
                    maxLength = tempLength;
                }
                tempLength = 0;
            }

        }
        return maxLength;
    }
}
