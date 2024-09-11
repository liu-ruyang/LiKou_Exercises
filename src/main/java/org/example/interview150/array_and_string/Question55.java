package org.example.interview150.array_and_string;

public class Question55 {
    // public boolean canJump(int[] nums) {
    //     int[] flag = new int[nums.length];
    //     flag[0] = 1;
    //
    //     for (int i = 0; i < nums.length; i++) {
    //         if (flag[i] == 1) {
    //             for (int j = i; j <= i + nums[i]; j++) {
    //                 if (j + nums[j] >= nums.length) {
    //                     return true;
    //                 }
    //
    //             }
    //             return true;
    //         }
    //         if (flag[i] == 1)
    //             flag[i + nums[i]] = 1;
    //     }
    //
    // }
    public boolean canJump(int[] nums) {
        int maxPosition = nums[0];

        for (int i = 0; i <= Integer.min(nums.length - 1, maxPosition); i++) {
            maxPosition = i + nums[i] > maxPosition ? i + nums[i] : maxPosition;
            if (maxPosition >= nums.length - 1) {
                return true;
            }
        }
        return false;

    }
}
