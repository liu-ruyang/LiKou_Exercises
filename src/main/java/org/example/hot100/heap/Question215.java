package org.example.hot100.heap;

import java.util.PriorityQueue;

public class Question215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((num1, num2) -> {
            return -Integer.compare(num1, num2);
        });
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }
        int res = 0;
        while (k-- > 0) res = heap.poll();
        return res;
    }
}
