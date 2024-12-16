package org.example.niuke_top101.heap_and_stack_and_queue;

import java.util.PriorityQueue;

public class BM48 {

    PriorityQueue largeTopHeap = new PriorityQueue((o1, o2) -> {
        return -Integer.compare((int) o1, (int) o2);
    });   // 中位数左边使用大顶堆
    PriorityQueue littleTopHeap = new
            PriorityQueue();  // 中位数右边使用小顶堆

    public static void main(String[] args) {
        BM48 bm48 = new BM48();
        bm48.Insert(5);
        bm48.GetMedian();
    }

    // 下面遵循左边大顶堆的元素数量 >= 右边小顶堆的元素数量
    public void Insert(Integer num) {
        if (largeTopHeap.size() == 0) {
            largeTopHeap.add(num);
        } else if (largeTopHeap.size() > littleTopHeap.size()) {
            if ((int) largeTopHeap.peek() <= num) {
                littleTopHeap.add(num);
            } else {
                littleTopHeap.add(largeTopHeap.poll());
                largeTopHeap.add(num);
            }
        } else {
            if ((int) littleTopHeap.peek() >= num) {
                largeTopHeap.add(num);
            } else {
                largeTopHeap.add(littleTopHeap.poll());
                littleTopHeap.add(num);
            }
        }
    }

    public Double GetMedian() {
        return largeTopHeap.size() > littleTopHeap.size() ? (int) largeTopHeap.peek() * 1.0
                : ((int) largeTopHeap.peek() + (int) littleTopHeap.peek()) / 2.0;
    }

}
