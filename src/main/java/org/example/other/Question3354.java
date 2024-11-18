package org.example.other;

import java.util.Arrays;

/**
 * 灵神改进：
 * 如果 nums[i]=0，分类讨论：
 * <p>
 * 如果前缀和 pre 等于后缀和 total−pre，那么小球初始方向可以向左可以向右，答案加 2。
 * 如果前缀和比后缀和多 1，那么小球初始方向必须向左，才能打掉所有砖块，答案加 1。
 * 如果前缀和比后缀和少 1，那么小球初始方向必须向右，才能打掉所有砖块，答案加 1。
 */
public class Question3354 {
    public static void main(String[] args) {
        int[] a = {1, 0, 2, 0, 3};
        new Question3354().countValidSelections(a);
    }

    public int countValidSelections(int[] nums) {

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int[] newNums = Arrays.copyOf(nums, nums.length);
                if (isOk(i, 1, newNums)) {
                    res++;
                }
                newNums = Arrays.copyOf(nums, nums.length);
                if (isOk(i, -1, newNums)) {
                    res++;
                }
            }
        }
        return res;
    }

    public boolean isOk(int curr, int step, int[] newNums) {
        while (curr >= 0 && curr < newNums.length) {
            curr += step;
            if (curr < 0 || curr >= newNums.length) {
                break;
            }
            if (newNums[curr] > 0) {
                step *= -1;
                newNums[curr]--;
            }
        }
        for (int newNum : newNums) {
            if (newNum != 0) {
                return false;
            }
        }
        return true;
    }
}
