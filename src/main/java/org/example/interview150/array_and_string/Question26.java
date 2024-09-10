package org.example.interview150.array_and_string;

public class Question26 {
    public int removeDuplicates0(int[] nums) {
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i + 1;
    }

    // 推荐
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int i = 1, j = 1;
        while (j < nums.length) {
            if (nums[i - 1] != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}
