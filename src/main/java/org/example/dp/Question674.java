package org.example.dp;

public class Question674 {
    public static void main(String[] args) {
        int a[] = {1, 3, 5, 4, 7};
        new Question674().findLengthOfLCIS(a);
    }

    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
//        return Arrays.stream(dp).max().getAsInt();
    }
}
