package org.example.niuke_top101.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class BM96 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 计算成功举办活动需要多少名主持人
     *
     * @param n        int整型 有n个活动
     * @param startEnd int整型二维数组 startEnd[i][0]用于表示第i个活动的开始时间，startEnd[i][1]表示第i个活动的结束时间
     * @return int整型
     */
    public int minmumNumberOfHost(int n, int[][] startEnd) {
        // write code here
        Arrays.sort(startEnd, (o1, o2) -> {
            return Integer.compare(o1[0], o2[0]);
        });

        PriorityQueue<int[]> smallHeap = new PriorityQueue<int[]>((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });

        // int res = 0;
        // int start = startEnd[0][0];
        int end = startEnd[0][1];
        for (int i = 0; i < startEnd.length; i++) {
            if (startEnd[i][0] < end) {
                // res++;
                if (smallHeap.isEmpty() || smallHeap.peek()[1] > startEnd[i][0]) {
                    smallHeap.add(startEnd[i]);
                } else {
                    smallHeap.poll();
                    smallHeap.add(startEnd[i]);
                }
            } else {
                // start = startEnd[i][0];
                end = startEnd[i][1];
                smallHeap.poll();
                smallHeap.add(startEnd[i]);
            }
        }

        return smallHeap.size();
    }
}
