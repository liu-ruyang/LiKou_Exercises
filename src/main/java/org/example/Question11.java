package org.example;

public class Question11 {
    public int maxArea(int[] height) {
        int maxSize = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int size = (right - left) * Integer.min(height[left], height[right]);
            if (size > maxSize) maxSize = size;
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxSize;
    }
}
