package org.example.monotonic_stack;

import java.util.Deque;
import java.util.LinkedList;

public class Question42 {
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();

        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    Integer popI = stack.pop();
                    if (!stack.isEmpty()) {
                        sum += (Integer.min(height[i], height[stack.peek()]) - height[popI]) * (i - stack.peek() - 1);
                    }
                }
                stack.push(i);
            }
        }

        return sum;
    }
}
