package org.example.hot100.two_pointers;

public class Question11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = Integer.MIN_VALUE;
        while (left < right) {
            if (Math.min(height[left], height[right]) * (right - left) > res) {
                res = Math.min(height[left], height[right]) * (right - left);
            }
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}
