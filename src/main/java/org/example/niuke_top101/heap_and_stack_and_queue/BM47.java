package org.example.niuke_top101.heap_and_stack_and_queue;

import java.util.PriorityQueue;

public class BM47 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a int整型一维数组
     * @param n int整型
     * @param K int整型
     * @return int整型
     */
    public int findKth(int[] a, int n, int K) {
        // write code here
        PriorityQueue<Integer> heap = new PriorityQueue((o1, o2) -> {
            return -Integer.compare((int) o1, (int) o2);
        });

        for (int i = 0; i < a.length; i++) {
            heap.add(a[i]);
        }

        for (int i = 0; i < K - 1; i++) {
            heap.poll();
        }

        return heap.poll();
    }
}
