package org.example.interview150.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Question502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // 所有项目，按照 成本 升序排序
        PriorityQueue<Pair> queue1 = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.capital, o2.capital);
            }
        });
        // 可以完成的项目队列，按照 利润-成本 降序排序
        PriorityQueue<Pair> queue2 = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return -Integer.compare(o1.profits, o2.profits);
            }
        });

        for (int i = 0; i < profits.length; i++) {
            queue1.add(new Pair(capital[i], profits[i]));
        }
        while (!queue1.isEmpty() && queue1.peek().capital <= w) {
            queue2.add(queue1.poll());
        }

        while (!queue2.isEmpty() && k > 0) {
            Pair pair = queue2.poll();
            w += pair.profits;
            k--;

            while (!queue1.isEmpty() && queue1.peek().capital <= w) {
                queue2.add(queue1.poll());
            }
        }
        return w;
    }

    class Pair {
        int capital;
        int profits;

        public Pair(int capital, int profits) {
            this.capital = capital;
            this.profits = profits;
        }
    }
}
