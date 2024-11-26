package org.example.interview150.heap;

import java.util.*;

public class Question373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return -Integer.compare(o1.get(0) + o1.get(1), o2.get(0) + o2.get(1));
            }
        });
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (count < k) {
                    queue.add(Arrays.asList(nums1[i], nums2[j]));
                    count++;
                } else {
                    List<Integer> peek = queue.peek();
                    if (peek.get(0) + peek.get(1) > nums1[i] + nums2[j]) {
                        queue.poll();
                        queue.add(Arrays.asList(nums1[i], nums2[j]));
                    } else {
                        break;
                    }
                }
            }
        }

        PriorityQueue<List<Integer>> queue2 = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return Integer.compare(o1.get(0) + o1.get(1), o2.get(0) + o2.get(1));
            }
        });
        while (!queue.isEmpty()) {
            queue2.add(queue.poll());
        }

        List<List<Integer>> res = new ArrayList<>();
        while (!queue2.isEmpty()) {
            res.add(queue2.poll());
        }
        // for (int i = 0; i < k; i++) {
        //     res.add(queue.poll());
        // }
        return res;
    }
}
