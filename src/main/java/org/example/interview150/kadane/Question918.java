package org.example.interview150.kadane;

import java.util.Arrays;

/**
 * 首先计算出连续最大子数组和、连续最小子数组和
 * 整个情况考虑三种：
 * 1. 数组中全是负数：最大的就是最大单个数字
 * 2. 数组中不全是负数，考虑是否需要首尾连接
 * ① 如果不需要首尾连接，则直接计算出最大连续子数组和
 * ② 如果需要首尾连接  ，则连续最小子数组是可以先计算出来，然后使用total-连续最小子数组和
 * （因为除去连续最小子数组部分，剩下的不菲就是可以通过首尾连接的，也就是使用环实现连续最大子数组和）
 */
public class Question918 {
    public static void main(String[] args) {
        // int[] a = {-5, -2, 5, 6, -2, -7, 0, 2, 8};
        int[] a = {1, -2, 3, -2};
        // int[] a = {52, 183, 124, 154, -170, -191, -240, 107, -178, 171, 75, 186, -125, 61, -298, 284, 21, -73, -294, 253, 146, 248, -248, 127, 26, 289, 118, -22, -300, 26, -116, -113, -44, 29, 252, -278, 47, 254, -106, 246, -275, 42, 257, 15, 96, -298, -69, -104, -239, -95, -4, 76, -202, 156, -14, -178, 188, -84, 78, -195, -125, 28, 109, 125, -25, -53, 58, 287, 55, -296, 198, 281, 53, -160, 146, 298, 25, -41, -3, 27, -242, 169, 287, -281, 19, 91, 213, 115, 211, -218, 124, -25, -272, 278, 296, -177, -166, -192, 97, -49, -25, 168, -81, 6, -94, 267, 293, 146, -1, -258, 256, 283, -156, 197, 28, 78, 267, -151, -230, -66, 100, -94, -66, -123, 121, -214, -182, 187, 65, -186, 215, 273, 243, -99, -76, 178, 59, 190, 279, 300, 217, 67, -117, 170, 163, 153, -37, -147, -251, 296, -176, 117, 68, 258};
        int i = new Question918().maxSubarraySumCircular(a);
        System.out.println(i);
    }

    public int maxSubarraySumCircular(int[] nums) {
        int min = 0;    // 局部连续最小和
        int minSum = Integer.MAX_VALUE; // 全局连续最小和
        int max = 0;    // 局部连续最大和
        int maxSum = Integer.MIN_VALUE; // 全局连续最大和
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min + nums[i], nums[i]);
            minSum = Math.min(min, minSum);
            max = Math.max(max + nums[i], nums[i]);
            maxSum = Math.max(max, maxSum);
        }

        if (maxSum < 0) {   // 数组中全是负数，则最大连续和就是最大的负数
            return maxSum;
        }
        int total = Arrays.stream(nums).sum();
        // 如果不全是负数的情况
        // ① 连续最大和不需要环，此情况连续最大和在数组中就是连续的，即maxSum值
        // ② 连续最大和需要环（即首尾连接），此情况连续最大和不连续，但是连续最小和是连续的，即minSum，再借助环，则maxSum = total - minSum
        return Math.max(maxSum, total - minSum);
    }

    // public int maxSubarraySumCircular(int[] nums) {
    //     int[] newNums = new int[nums.length * 2];
    //     for (int i = 0; i < newNums.length; i++) {
    //         newNums[i] = nums[i % nums.length];
    //     }
    //
    //     int n = nums.length;
    //     int len = 0;
    //     int leftIndex = 0;
    //     int preSum = 0;
    //     int res = Integer.MIN_VALUE;
    //
    //     for (int i = 0; i < newNums.length; i++) {
    //         if (preSum > 0) {
    //             if (len < n) {
    //                 preSum += newNums[i];
    //                 len++;
    //             } else {
    //                 preSum += -newNums[leftIndex] + newNums[i];
    //                 leftIndex++;
    //             }
    //
    //             if (len > n) {
    //                 preSum += -newNums[leftIndex];
    //                 leftIndex++;
    //                 len--;
    //             }
    //
    //             while (newNums[leftIndex] <= 0) {
    //                 preSum += -newNums[leftIndex];
    //                 leftIndex++;
    //                 len--;
    //             }
    //
    //
    //         } else if (preSum <= 0) {
    //             preSum = newNums[i];
    //             len = 1;
    //             leftIndex = i;
    //         }
    //
    //         res = Integer.max(res, preSum);
    //     }
    //
    //     return res;
    // }

    // public int maxSubarraySumCircular(int[] nums) {
    //     int result = Integer.MIN_VALUE;
    //     int temp = Integer.MIN_VALUE;
    //
    //     for (int i = 0; i < nums.length; i++) {
    //         if (temp > 0) {
    //             temp += nums[i];
    //         } else {
    //             temp = nums[i];
    //         }
    //         result = temp > result ? temp : result;
    //     }
    //
    //     int result2 = Integer.MIN_VALUE;
    //     temp = Integer.MIN_VALUE;
    //     for (int i = nums.length - 1; i >= 0; i--) {
    //         if (temp > 0) {
    //             temp += nums[i];
    //         } else {
    //             temp = nums[i];
    //         }
    //         result = temp > result ? temp : result;
    //     }
    //     for (int i = 0; i < nums.length; i++) {
    //         if (temp > 0) {
    //             temp += nums[i];
    //         } else {
    //             temp = nums[i];
    //         }
    //         result = temp > result ? temp : result;
    //     }
    //
    //
    // }
    // public int maxSubarraySumCircular(int[] nums) {
    //     int[] newNums = new int[nums.length * 2];
    //     for (int i = 0; i < newNums.length; i++) {
    //         newNums[i] = nums[i % nums.length];
    //     }
    //
    //     int result = Integer.MIN_VALUE;
    //     int temp = Integer.MIN_VALUE;
    //     int len = 0;
    //     int leftIndex = 0;
    //     int maxLength = nums.length;
    //     for (int i = 0; i < newNums.length; i++) {
    //         // 1.直接添加
    //         // if (temp > 0 && len < maxLength) {
    //         if (temp > 0) {
    //             temp += newNums[i];
    //             len++;
    //         }
    //
    //         // 2.前面的和为负值，重新添加
    //         else if (temp <= 0) {
    //             temp = newNums[i];
    //             len = 1;
    //             leftIndex = i;
    //         }
    //
    //         // 2.超过长度限制
    //         if (len > maxLength) {
    //             temp -= newNums[leftIndex];
    //             len--;
    //             leftIndex++;
    //             while (newNums[leftIndex] <= 0) {
    //                 temp -= newNums[leftIndex];
    //                 len--;
    //                 leftIndex++;
    //             }
    //         }
    //
    //         result = temp > result ? temp : result;
    //
    //     }
    //     return result;
    // }

    // public int maxSubarraySumCircular(int[] nums) {
    //     int[] newNums = new int[nums.length * 2];
    //     for (int i = 0; i < newNums.length; i++) {
    //         newNums[i] = nums[i % nums.length];
    //     }
    //
    //     int result = Integer.MIN_VALUE;
    //     int temp = Integer.MIN_VALUE;
    //     int len = 0;
    //     int leftIndex = 0;
    //     for (int i = 0; i < newNums.length; i++) {
    //         if (len == nums.length) {
    //             temp -= newNums[leftIndex];
    //             len--;
    //             leftIndex++;
    //         }
    //         while (leftIndex < i && newNums[leftIndex] < 0) {
    //             temp -= newNums[leftIndex];
    //             len--;
    //             leftIndex++;
    //         }
    //
    //         if (temp > 0) {
    //             temp += newNums[i];
    //             len++;
    //         } else {
    //             temp = newNums[i];
    //             len = 1;
    //             leftIndex = i;
    //         }
    //
    //         result = temp > result ? temp : result;
    //     }
    //     return result;
    // }


}
