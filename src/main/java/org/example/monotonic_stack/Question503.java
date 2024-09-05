package org.example.monotonic_stack;

import java.util.Deque;
import java.util.LinkedList;

public class Question503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }

        for (int i = 0; i < nums.length * 2; i++) {
            if (stack.isEmpty()) {
                stack.push(i % nums.length);
            } else {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                    res[stack.peek()] = nums[i % nums.length];
                    stack.pop();
                }
                stack.push(i % nums.length);
            }
        }

        return res;
    }
}
