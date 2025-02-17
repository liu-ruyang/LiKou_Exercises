package org.example.review.skill;

public class Question287 {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                int temp = nums[nums[i] - 1];
                if (temp == nums[i]) {
                    return temp;
                }
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        return 0;
    }
}
