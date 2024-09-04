package org.example.monotonic_stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Question496 {
    public static void main(String[] args) {
        int a[] = {1, 3, 5, 2, 4};
        int b[] = {5, 4, 3, 2, 1};
        new Question496().nextGreaterElement(a, b);

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Deque<Integer> stack = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                    map.put(nums2[stack.peek()], nums2[i]);
                    stack.pop();
                }
                stack.push(i);
            }
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                res[i] = map.get(nums1[i]);
            } else
                res[i] = -1;
        }
        return res;
    }
}
