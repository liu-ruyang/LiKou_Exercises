package org.example.niuke_top101.heap_and_stack_and_queue;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class BM46 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param input int整型一维数组
     * @param k     int整型
     * @return int整型ArrayList
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        // write code here
        PriorityQueue<Integer> heap = new PriorityQueue((o1, o2) -> {
            return Integer.compare((int) o1, (int) o2);
        });

        for (int i = 0; i < input.length; i++) {
            heap.add(input[i]);
        }

        ArrayList<Integer> res = new ArrayList();
        for (int i = 0; i < k; i++) {
            res.add(heap.poll());
        }

        return res;
    }
}
