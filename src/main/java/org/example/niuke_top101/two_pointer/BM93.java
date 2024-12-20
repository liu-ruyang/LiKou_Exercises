package org.example.niuke_top101.two_pointer;

public class BM93 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param height int整型一维数组
     * @return int整型
     */
    public int maxArea(int[] height) {
        // write code here
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            res = Math.max((right - left) * Math.min(height[left], height[right]), res);
            if (height[left] > height[right]) right--;
            else left++;
        }
        return res;
    }
}
