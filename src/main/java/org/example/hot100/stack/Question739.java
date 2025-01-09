package org.example.hot100.stack;

import java.util.LinkedList;

public class Question739 {
    /**
     * 单调栈思路
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        LinkedList<Integer> stack = new LinkedList<>(); // 单调栈，存放下标
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer peek = stack.peek();
                res[peek] = i - peek;
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
