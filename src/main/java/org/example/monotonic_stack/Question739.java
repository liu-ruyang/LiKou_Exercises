package org.example.monotonic_stack;

import java.util.Deque;
import java.util.LinkedList;

public class Question739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    Integer pop = stack.pop();
                    res[pop] = i - pop;
                }
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            res[pop] = 0;
        }
        return res;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    Integer pop = stack.pop();
                    res[pop] = i - pop;
                }
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            res[pop] = 0;
        }
        return res;
    }
}
