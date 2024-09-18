package org.example.greedy_question;

public class Question45 {
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;

        int curDistance = 0;    // 当前覆盖最远距离下标
        int ans = 0;            // 记录走的最大步数
        int nextDistance = 0;   // 下一步覆盖最远距离下标

        for (int i = 0; i < nums.length; i++) {
            nextDistance = Integer.max(nextDistance, nums[i] + i);

            if (i == curDistance) {
                ans++;
                curDistance = nextDistance;
            }
            if (curDistance >= nums.length - 1) {
                return ans;
            }

        }

        return ans;
    }
}
