package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Solution4 {

    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = -1;
        }

        // TreeMap<Integer, Integer> treeMap = new TreeMap<>();


        // TreeMap数据结构会根据key进行排序
        TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int temp = nums1[i] + nums2[i];
            if (treeMap.containsKey(temp)) {
                ArrayList iIndexs = treeMap.get(temp);
                iIndexs.add(i);
            } else {
                ArrayList<Integer> iIndexs = new ArrayList<>();
                iIndexs.add(i);
                treeMap.put(temp, iIndexs);
            }
        }

        //
        Set<Integer> keySet = treeMap.keySet();
        List<Integer> integers = keySet.stream().toList();

        for (int k = 0; k < queries.length; k++) {
            for (int i = integers.size() - 1; i >= 0; i--) {
                // ArrayList<Integer> list = treeMap.get(i);
                ArrayList<Integer> list = treeMap.get(integers.get(i));
                for (int j = 0; j < list.size(); j++) {
                    if (nums1[list.get(j)] >= queries[k][0] && nums2[list.get(j)] >= queries[k][1]) {
                        answer[k] = integers.get(i);
                        break;
                    }
                }
                if (answer[k] != -1)
                    break;
            }
        }


        // for (int i = 0; i < queries.length; i++) {
        //     treeMap;

        // for (int j = 0; j < nums1.length; j++) {
        //     if (nums1[j] >= queries[i][0] && nums2[j] >= queries[i][1]) {
        //         temp = nums1[j] + nums2[j] > temp ? nums1[j] + nums2[j] : temp;
        //     }
        // }
        // answer[i] = temp;
        // temp = -1;
        // }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 3, 1, 2};
        int[] nums2 = {2, 4, 9, 5};
        int[][] queries = {{4, 1}, {1, 3}, {2, 5}};
        int[] ints = new Solution4().maximumSumQueries(nums1, nums2, queries);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }

    // public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
    //     int[] answer = new int[queries.length];
    //     int[] sortSum = new int[nums1.length];
    //     int temp = -1;
    //     for (int i = 0; i < queries.length; i++) {
    //         for (int j = 0; j < nums1.length; j++) {
    //             if (nums1[j] >= queries[i][0] && nums2[j] >= queries[i][1]) {
    //                 temp = nums1[j] + nums2[j] > temp ? nums1[j] + nums2[j] : temp;
    //             }
    //         }
    //         answer[i] = temp;
    //         temp = -1;
    //     }
    //     return answer;
    // }
    //
    // public void sort(int[] sortSum, int[] nums1, int[] nums2) {
    //     for (int i = 0; i < nums1.length; i++) {
    //         sortSum[i] = nums1[i] + nums2[i];
    //     }
    //
    //
    //     int[] temp = new int[sortSum.length];
    //     mergeSort(sortSum, 0, sortSum.length - 1, temp, nums1, nums2);
    //
    // }
    //
    //
    // public static void mergeSort(int[] arr, int left, int right, int[] temp, int[] nums1, int[] nums2) {
    //     if (left < right) {
    //         int mid = (left + right) / 2; // 因为是二路归并
    //
    //         mergeSort(arr, left, mid, temp, nums1, nums2);// 分递归中间左边
    //
    //         mergeSort(arr, mid + 1, right, temp, nums1, nums2);// 分递归中间的右边
    //
    //         merge(arr, left, mid, right, temp);// 这是治的思想调用函数拼一起
    //
    //     }
    // }
    //
    // public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
    //
    //     int i = left;
    //     int j = mid + 1;
    //     int t = 0;
    //     // 当满足下面条件不断循环
    //     while (i <= mid && j <= right) {
    //         if (arr[i] <= arr[j]) {// 如果左边小
    //             temp[t] = arr[i];
    //             t += 1;
    //             i += 1;
    //         } else {
    //             temp[t] = arr[j];
    //             t += 1;
    //             j += 1;
    //         }
    //     }
    //
    //     /**
    //      * 下面是当到尾还有剩余元素就直接放temp尾部里
    //      */
    //     while (i <= mid) { // 将左边元素填充到temp
    //         temp[t] = arr[i];
    //         t += 1;
    //         i += 1;
    //     }
    //
    //     while (j <= right) {
    //         temp[t] = arr[j];
    //         t += 1;
    //         j += 1;
    //     }
    //
    //     // 将temp里元素拷贝到arr数组里
    //     t = 0;
    //     int tempLeft = left; //
    //     while (tempLeft <= right) {
    //         arr[tempLeft] = temp[t];
    //         t += 1;
    //         tempLeft += 1;
    //     }
    //
    // }

}
