package org.example.review.dp;

import java.util.Arrays;

public class Question3040 {
    public static void main(String[] args) {
        int[] a = {3, 2, 1, 2, 3, 4};
        new Question3040().maxOperations(a);
    }

    public int maxOperations(int[] nums) {
        int res = 0;
        int[][] record = new int[nums.length][nums.length];

        for (int[] dp : record) {
            Arrays.fill(dp, -1);
        }
        dfs(nums, nums[0] + nums[1], 0, nums.length - 1, record);
        res = Math.max(res, record[0][nums.length - 1]);

        for (int[] dp : record) {
            Arrays.fill(dp, -1);
        }
        dfs(nums, nums[0] + nums[nums.length - 1], 0, nums.length - 1, record);
        res = Math.max(res, record[0][nums.length - 1]);

        for (int[] dp : record) {
            Arrays.fill(dp, -1);
        }
        dfs(nums, nums[nums.length - 1] + nums[nums.length - 2], 0, nums.length - 1, record);
        res = Math.max(res, record[0][nums.length - 1]);

        return res;
    }

    public void dfs(int[] nums, int target, int left, int right, int[][] record) {
        if (left == right) {
            record[left][right] = 0;
            return;
        }
        if (left > right) {
            return;
        }
        if (left + 1 == right) {
            record[left][right] = nums[left] + nums[right] == target ? 1 : 0;
            return;
        }

        if (nums[left] + nums[left + 1] == target) {
            if (record[left + 2][right] == -1) {
                dfs(nums, target, left + 2, right, record);
            }
            record[left][right] = Math.max(record[left][right], record[left + 2][right] + 1);
        }

        if (nums[right] + nums[right - 1] == target) {
            if (record[left][right - 2] == -1) {
                dfs(nums, target, left, right - 2, record);
            }
            record[left][right] = Math.max(record[left][right], record[left][right - 2] + 1);
        }

        if (nums[left] + nums[right] == target) {
            if (record[left + 1][right - 1] == -1) {
                dfs(nums, target, left + 1, right - 1, record);
            }
            record[left][right] = Math.max(record[left][right], record[left + 1][right - 1] + 1);
        }

        record[left][right] = Math.max(record[left][right], 0);
    }
}
