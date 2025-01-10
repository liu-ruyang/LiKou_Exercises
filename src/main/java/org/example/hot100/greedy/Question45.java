package org.example.hot100.greedy;

public class Question45 {
    // 贪心算法（推荐），要记录三个值：
    // ① 当前覆盖最远距离下标
    // ② 走的步数
    // ③ 下一步覆盖最远距离下标
    public int jump(int[] nums) {
        int curMax = 0;
        int step = 0;
        int nextMax = 0;

        for (int i = 0; i < nums.length; i++) {
            nextMax = Math.max(nextMax, i + nums[i]);   // 当前步数是step，nextMax表示的是step+1步时最大可以到达的位置，留待更新curMax用

            if (i == curMax) {  // 已经走到了step可以到达的最远的位置，则需要加一步，并将step+1步可以到达的最远的位置更新到curMax值
                step++;
                curMax = nextMax;
            }

            if (curMax >= nums[nums.length - 1]) {  // step步的情况下，最远可到达的位置已经到了终点，返回结果
                return step;
            }
        }
        return -1;    // 由于本题已经声明了可以到达终点，所以这里返回的值多少无所谓
    }

    // 动态规划，暴力解法（但是由于本题已经声明确定可以到达终点，所以本方法中的很多的判断条件是可以省略的）
    //    public int jump(int[] nums) {
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
    //        return dp[nums.length - 1] == Integer.MAX_VALUE ? -1 : dp[nums.length - 1];
    //    }
}
