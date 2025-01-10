package org.example.hot100.heap;

import java.util.PriorityQueue;

public class Question295 {
    public static void main(String[] args) {
        MedianFinder finder = new Question295().new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        double median = finder.findMedian();
        finder.addNum(3);
        double median1 = finder.findMedian();
    }

    class MedianFinder {
        // 保持大顶堆的元素个数不少于小顶堆的元素个数
        PriorityQueue<Integer> bigTopHeap;
        PriorityQueue<Integer> smallTopHeap;

        public MedianFinder() {
            bigTopHeap = new PriorityQueue<>(((o1, o2) -> -Integer.compare(o1, o2)));
            smallTopHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (bigTopHeap.size() == 0) {
                bigTopHeap.add(num);
            } else if (bigTopHeap.size() == smallTopHeap.size()) {
                smallTopHeap.add(num);
                bigTopHeap.add(smallTopHeap.poll());
            } else if (bigTopHeap.size() > smallTopHeap.size()) {
                bigTopHeap.add(num);
                smallTopHeap.add(bigTopHeap.poll());
            }
            // 小顶堆的元素个数不会比大顶堆的元素个数多
        }

        public double findMedian() {
            return bigTopHeap.size() == smallTopHeap.size() ? (bigTopHeap.peek() + smallTopHeap.peek()) / 2.0 : bigTopHeap.peek();
        }
    }
}
