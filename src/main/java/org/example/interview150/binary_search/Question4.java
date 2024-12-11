package org.example.interview150.binary_search;

public class Question4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0; // p1、p2所指位置元素表示即将加入到左边，但还没加入左边；同时p1、p2可以表示两个数组加入到左边的元素个数
        int halfNum = (nums1.length + nums2.length) / 2;
        int max = Integer.MIN_VALUE;
        while (p1 + p2 < halfNum) {
            if (p2 >= nums2.length || p1 < nums1.length && nums1[p1] <= nums2[p2]) {
                max = Math.max(max, nums1[p1]);
                p1++;
            } else {
                max = Math.max(max, nums2[p2]);
                p2++;
            }
        }

        // 已找出halfNum个数字，下面计算中位数，按总数奇偶性分两种情况：
        if ((nums1.length + nums2.length) % 2 == 0) {
            // 下一个元素和当前最后一个元素取均值
            if (p2 >= nums2.length || p1 < nums1.length && nums1[p1] <= nums2[p2]) {
                return (max + nums1[p1]) / 2.0;
            } else {
                return (max + nums2[p2]) / 2.0;
            }
        } else {
            // 下一个元素
            if (p2 >= nums2.length || p1 < nums1.length && nums1[p1] <= nums2[p2]) {
                return nums1[p1];
            } else {
                return nums2[p2];
            }
        }
    }

    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int left = 0, right = nums1.length - 1;
    //     int halfNum = (nums1.length + nums2.length) / 2;
    //
    //     while (left < right) {
    //         int mid1 = (left + right) / 2;  // nums1尝试的中位数下标
    //         int mid2 = (halfNum - 1 - 1 - mid1);    // nums2尝试的中位数下标
    //         if (mid2 == -1 && nums1[mid1] <= nums2[0]) {
    //
    //         }
    //         if (mid2 >= 0 && mid2 < nums2.length) {
    //
    //         }
    //
    //     }
    //     return 0;
    // }
}
