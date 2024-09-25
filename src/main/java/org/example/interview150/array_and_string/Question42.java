package org.example.interview150.array_and_string;

import java.util.Deque;
import java.util.LinkedList;

public class Question42 {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        new Question42().trap(a);
    }

    public int trap(int[] height) {
        // 保持栈中元素严格递增
        Deque stack = new LinkedList();
        int result = 0;

        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                int peek = (int) stack.peek();
                while (!stack.isEmpty() && height[peek] <= height[i]) {
                    int pop = (int) stack.pop();
                    if (!stack.isEmpty()) {
                        result += (i - (int) stack.peek() - 1)
                                * (Integer.min(height[(int) stack.peek()], height[i]) - height[pop]);
                        peek = (int) stack.peek();
                    }
                }
                stack.push(i);
            }
        }
        return result;
    }
}
