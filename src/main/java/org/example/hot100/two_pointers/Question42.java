package org.example.hot100.two_pointers;

import java.util.LinkedList;

public class Question42 {
    public static void main(String[] args) {
        // int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] a = {4, 2, 0, 3, 2, 5};
        new Question42().trap(a);
    }

    public int trap(int[] height) {
        LinkedList<Integer> stack = new LinkedList<>();
        int res = 0;
        if (height.length == 0) {
            return res;
        }

        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty() || height[stack.peek()] > height[i]) {
                stack.push(i);
            } else if (height[stack.peek()] == height[i]) {     // 这一种情况其实可以注掉，就按照下一个else if处理逻辑处理也正确
                stack.pop();
                stack.push(i);
            } else if (height[stack.peek()] < height[i]) {
                while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    Integer pop = stack.pop();
                    if (!stack.isEmpty()) {
                        res += (Math.min(height[stack.peek()], height[i]) - height[pop]) * (i - stack.peek() - 1);
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }
}
