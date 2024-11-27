package org.example.interview150.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Question295 {
    /**
     * 在数据流中，数据会不断涌入结构中，那么也就面临着需要多次动态调整以获得中位数。 因此实现的数据结构需要既需要快速找到中位数，也需要做到快速调整。
     * 首先能想到就是二叉搜索树，在平衡状态下，树顶必定是中间数，然后再根据长度的奇偶性决定是否取两个数。
     * 此方法效率高，但是手动编写较费时费力。
     * 根据只需获得中间数的想法，可以将数据分为左右两边，一边以最大堆的形式实现，可以快速获得左侧最大数， 另一边则以最小堆的形式实现。其中需要注意的一点就是左右侧数据的长度差不能超过1。 这种实现方式的效率与AVL平衡二叉搜索树的效率相近，但编写更快
     */
    class MedianFinder {

        PriorityQueue<Integer> littleHeap;  // 比中位数小的数字使用大顶堆存储
        PriorityQueue<Integer> largeHeap;   // 比中位数大的数字使用小顶堆存储

        public MedianFinder() {
            // 大顶堆
            littleHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return -Integer.compare(o1, o2);
                }
            });
            // 小顶堆
            largeHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o1, o2);
                }
            });
        }

        public void addNum(int num) {
            if (littleHeap.isEmpty() && largeHeap.isEmpty()) {
                littleHeap.add(num);
            } else if (littleHeap.isEmpty() && !largeHeap.isEmpty()) {
                if (largeHeap.peek() >= num) {
                    littleHeap.add(num);
                } else {
                    littleHeap.add(largeHeap.poll());
                    largeHeap.add(num);
                }
            } else if (!littleHeap.isEmpty() && largeHeap.isEmpty()) {
                if (littleHeap.peek() <= num) {
                    largeHeap.add(num);
                } else {
                    largeHeap.add(littleHeap.poll());
                    littleHeap.add(num);
                }
            } else {
                if (num <= littleHeap.peek()) {
                    if (littleHeap.size() <= largeHeap.size()) {
                        littleHeap.add(num);
                    } else {
                        largeHeap.add(littleHeap.poll());
                        littleHeap.add(num);
                    }
                } else if (num >= largeHeap.peek()) {
                    if (largeHeap.size() <= littleHeap.size()) {
                        largeHeap.add(num);
                    } else {
                        littleHeap.add(largeHeap.poll());
                        largeHeap.add(num);
                    }
                } else {
                    if (littleHeap.size() <= largeHeap.size()) {
                        littleHeap.add(num);
                    } else {
                        largeHeap.add(num);
                    }
                }
            }
        }

        public double findMedian() {
            if (littleHeap.size() == largeHeap.size()) {
                return (littleHeap.peek() + largeHeap.peek()) * 1.0 / 2;
            } else {
                return littleHeap.size() > largeHeap.size() ? littleHeap.peek() : largeHeap.peek();
            }
        }
    }
}
