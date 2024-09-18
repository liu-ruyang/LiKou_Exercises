package org.example.greedy_question;

public class Question55 {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length && i <= max; i++) {
            max = Integer.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
