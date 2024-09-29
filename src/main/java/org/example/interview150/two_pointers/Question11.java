package org.example.interview150.two_pointers;

public class Question11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxSize = 0;

        while (left < right) {
            int size = (right - left) * Integer.min(height[left], height[right]);
            maxSize = size > maxSize ? size : maxSize;

            // 只有动矮的一侧的指针才有机会使得面积变大
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxSize;
    }
}
