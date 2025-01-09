package org.example.hot100.stack;

import java.util.LinkedList;

public class Question84 {
    public static void main(String[] args) {
        int[] a = {2, 1, 5, 6, 2, 3};
        new Question84().largestRectangleArea(a);
    }

    /**
     * 对比 Question42接雨水问题：
     * 接雨水是找每个主子左右两边第一个大于该柱子高度的柱子（从栈头到栈尾，保持降序）
     * 而本题是找每个柱子左右两边第一个小于该柱子的柱子（从栈头到栈尾，保持升序）
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int[] nums = new int[heights.length + 2];
        nums[0] = 0;
        nums[nums.length - 1] = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            nums[i] = heights[i - 1];
        }

        int res = 0;

        LinkedList<Integer> stack = new LinkedList<>();
        // 从栈头到栈尾，保持升序（是找每个柱子左右两边第一个小于该柱子的柱子）
        // 本质思想：每次遍历到一个小于栈顶的数字，就计算一下 以当前栈顶所在位置的高度作为高度，到两壁，能得到的最大的面积
        // 比较接雨水：接雨水的本质思想：每次遍历到一个大于栈顶的数字，就计算一下 以当前栈顶所在位置的高度作为盛水的底，到两壁，能得到的最大盛水量
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] >= nums[stack.peek()]) {
                stack.push(i);
            } else if (nums[i] < nums[stack.peek()]) {
                while (nums[stack.peek()] > nums[i]) {
                    Integer pop = stack.pop();
                    int tempArea = nums[pop] * (i - stack.peek() - 1);
                    res = Math.max(tempArea, res);
                }
                stack.push(i);
            }
        }
        return res;
    }
}
