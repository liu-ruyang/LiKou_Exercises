package org.example.interview150.array_and_string;

public class Question45 {
    public static void main(String[] args) {
        int[] a = {2, 3, 1, 1, 4};
        new Question45().jump(a);
    }

    public int jump2(int[] nums) {
        int[] dp = new int[nums.length];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;


        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i)
                    dp[i] = Integer.min(dp[i], dp[j] + 1);
            }
        }
        return dp[nums.length - 1];

    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                dp[i + j] = Integer.min(dp[i + j], dp[i] + 1);
            }

        }
        return dp[nums.length - 1];
    }
}
