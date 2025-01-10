package org.example.hot100.greedy;

public class Question55 {
    public static void main(String[] args) {
//        int[] a = {2, 3, 1, 1, 4};
        int[] a = {1, 0, 8, 0};
        new Question55().canJump(a);
    }

    public boolean canJump(int[] nums) {
        int farthest = 0; // 当前最远可到达的位置

        for (int i = 0; i < nums.length && i <= farthest; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
//    public boolean canJump(int[] nums) {
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (dp[i] != Integer.MAX_VALUE) {
//                for (int j = 1; j <= nums[i]; j++) {
//                    int step = i + j;
//                    if (step < nums.length - 1) {
//                        dp[step] = Math.min(dp[step], dp[i] + 1);
//                    } else {
//                        dp[nums.length - 1] = Math.min(dp[nums.length - 1], dp[i] + 1);
//                    }
//                }
//            }
//        }
//
//        return dp[nums.length - 1] == Integer.MAX_VALUE ? false : true;
//    }
}
