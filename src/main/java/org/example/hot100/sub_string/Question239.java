package org.example.hot100.sub_string;

import java.util.ArrayList;
import java.util.LinkedList;

// 使用单调队列
public class Question239 {
    public static void main(String[] args) {
        int[] a = {1};
        new Question239().maxSlidingWindow(a, 1);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int index = 0;
        LinkedList<Integer> deque = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        while (index < nums.length) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[index]) {
                deque.removeLast();
            }
            deque.add(index);
            if (index - deque.peek() + 1 > k) {
                deque.pop();
            }
            if (index >= k - 1) {
                res.add(nums[deque.peek()]);
            }
            index++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
