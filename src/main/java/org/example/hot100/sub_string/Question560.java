package org.example.hot100.sub_string;

import java.util.HashMap;

/**
 * 前缀和应用场景：
 * 1. 一维数组的区间求和
 * 2. 二维数组的区域求和
 * 3. 滑动窗口问题：例如，求解给定长度的连续子数组的最大和或最小和，前缀和能够快速计算每个窗口内的元素和，并结合其他算法进行优化。
 */
public class Question560 {
    public static void main(String[] args) {
        int[] a = {1, 2, 1, 2, 1};
        new Question560().subarraySum(a, 3);
    }

    // 前缀和+哈希表优化：
    // 考虑以 i 结尾的和为 k 的连续子数组个数时只要统计有多少个前缀和为 pre[i]−k 的 pre[j] 即可
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();    // 键值：前缀和--数量
        map.put(0, 1);  // 空是一种情况
        int preSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum - k)) {      // 前缀和-k值！！！
                count += map.get(preSum - k);
            }
            // 更新哈希表信息
            if (!map.containsKey(preSum)) {
                map.put(preSum, 1);
            } else {
                map.put(preSum, map.get(preSum) + 1);
            }
        }

        return count;
    }

    // 前缀和
    // public int subarraySum(int[] nums, int k) {
    //     int[] preSum = new int[nums.length];    // 前缀和
    //     preSum[0] = nums[0];
    //     for (int i = 1; i < nums.length; i++) {
    //         preSum[i] = preSum[i - 1] + nums[i];
    //     }
    //     int count = 0;
    //
    //     for (int i = 0; i < preSum.length; i++) {
    //         if (preSum[i] == k) {
    //             count++;
    //         }
    //         for (int j = 0; j < i; j++) {
    //             if (preSum[i] - preSum[j] == k) {
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }
}
