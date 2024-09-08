package org.example.monotonic_stack;

import java.util.Deque;
import java.util.LinkedList;

public class Question84 {
    public int largestRectangleArea(int[] heights) {
        // 情况一：当前遍历的元素heights[i]大于栈顶元素heights[st.top()]的情况
        // 情况二：当前遍历的元素heights[i]等于栈顶元素heights[st.top()]的情况
        // 情况三：当前遍历的元素heights[i]小于栈顶元素heights[st.top()]的情况

        // 数组扩容，在头和尾各加入一个元素 0，避免一直走不到情况三
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++) {
            newHeights[index + 1] = heights[index];
        }

        Deque<Integer> stack = new LinkedList<>();

        int maxArea = 0;
        for (int i = 0; i < newHeights.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
                    Integer popI = stack.pop();
                    // 每次和上一次maxArea进行比较的是，以当前栈顶的元素作为高度 可以得到的最大面积
                    maxArea = Math.max((i - stack.peek() - 1) * newHeights[popI], maxArea);
                }
                stack.push(i);
            }
        }
        return maxArea;
    }
}
