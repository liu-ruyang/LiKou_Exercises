package org.example.hot100.binary_search;

import java.util.ArrayList;

public class Question4 {
    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {3, 4};
        new Question4().findMedianSortedArrays(a, b);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int count = (len1 + len2) / 2 + 1;

        int index1 = 0;
        int index2 = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (; list.size() < count && index1 < nums1.length && index2 < nums2.length; ) {
            if (nums1[index1] < nums2[index2]) {
                list.add(nums1[index1]);
                index1++;
            } else {
                list.add(nums2[index2]);
                index2++;
            }
        }
        for (; list.size() < count && index1 < nums1.length; ) {
            list.add(nums1[index1]);
            index1++;
        }
        for (; list.size() < count && index2 < nums2.length; ) {
            list.add(nums2[index2]);
            index2++;
        }

        if ((len1 + len2) % 2 == 0) {
            return (list.get(list.size() - 1) + list.get(list.size() - 2)) / 2.0;
        } else {
            return list.get(list.size() - 1);
        }
    }
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int left = 0;
//        int right = nums1.length - 1;
//        int totalLeft = (nums1.length + nums2.length + 1) / 2;
//
//        while (left < right) {
//            int mid1 = (left + right) / 2;  // nums1的分界线的位置下标
//            int mid2 = totalLeft - (mid1 + 1) - 1;  // nums2的分界线的位置下标
//
////            if ()
//
//        }
//        return 0;
//    }
}
