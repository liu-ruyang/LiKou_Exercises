package org.example.hot100.heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Question347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();    // 键-值：数字-出现次数
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }

        PriorityQueue<Pair> heap = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1.count, o2.count));
        map.forEach((num, count) -> heap.add(new Pair(num, count)));

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll().num;
        }

        return res;
    }

    class Pair {
        int num;
        int count;

        public Pair() {
        }

        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
