package org.example.interview150.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            dfs(nums, i, list, res, visited);
        }

        return res;
    }

    // 对下标为index的元素做选择，选取 和 不选取
    public void dfs(int[] nums, int index, List<Integer> list, List<List<Integer>> res, boolean[] visited) {
        list.add(nums[index]);
        visited[index] = true;

        if (list.size() == nums.length) {
            ArrayList<Integer> newList = new ArrayList<>(list);
            res.add(newList);
            list.remove(list.size() - 1);
            visited[index] = false;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                dfs(nums, i, list, res, visited);
            }
        }

        list.remove(list.size() - 1);
        visited[index] = false;
    }
}
