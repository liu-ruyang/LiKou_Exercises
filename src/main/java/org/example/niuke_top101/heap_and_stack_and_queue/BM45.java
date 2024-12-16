package org.example.niuke_top101.heap_and_stack_and_queue;

import java.util.ArrayList;
import java.util.LinkedList;

public class BM45 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param num  int整型一维数组
     * @param size int整型
     * @return int整型ArrayList
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        // write code here
        LinkedList<Integer> queue = new LinkedList();
        ArrayList<Integer> res = new ArrayList();
        if (num.length < size || size <= 0) {
            return res;
        }
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            temp = Math.max(temp, num[i]);
            queue.add(num[i]);
        }
        res.add(temp);

        for (int i = size; i < num.length; i++) {
            queue.removeFirst();
            queue.add(num[i]);
            temp = Integer.MIN_VALUE;
            for (int j = 0; j < queue.size(); j++) {
                temp = Math.max(temp, queue.get(j));
            }
            res.add(temp);
        }
        return res;
    }
}
