package org.example.other;

public class Question3038 {
    public int maxOperations(int[] nums) {
        int count = 0;
        int num = nums[0] + nums[1];
        for (int i = 0; i + 1 < nums.length; i += 2) {
            if (nums[i] + nums[i + 1] == num) {
                count++;
            } else {
                return count;
            }
        }
        return count;
    }
}
