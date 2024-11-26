package org.example.interview150.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Question215 {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }

        for (int i = 0; i < k; i++) {
            int res = queue.poll();
            if (i == k - 1) {
                return res;
            }
        }

        return -1;
    }
}
