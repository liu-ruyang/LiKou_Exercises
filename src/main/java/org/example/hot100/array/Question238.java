package org.example.hot100.array;

public class Question238 {
    public int[] productExceptSelf(int[] nums) {
        int[] dp1 = new int[nums.length];
        dp1[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp1[i] = dp1[i - 1] * nums[i];
        }
        int[] dp2 = new int[nums.length];
        dp2[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            dp2[i] = dp2[i + 1] * nums[i];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            if (i == 0) {
                res[i] = dp2[i + 1];
            } else if (i == res.length - 1) {
                res[i] = dp1[i - 1];
            } else {
                res[i] = dp1[i - 1] * dp2[i + 1];
            }
        }

        return res;
    }
}
