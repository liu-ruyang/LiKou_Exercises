package org.example.hot100.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[nums.length];
        Arrays.fill(visited, 0);
        dfs(nums, 0, res, list, visited);
        return res;
    }

    public void dfs(int[] nums, int count, List<List<Integer>> res, List<Integer> list, int[] visited) {
        if (count >= nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0) {
                list.add(nums[i]);
                visited[i] = 1;
                dfs(nums, count + 1, res, list, visited);
                // 恢复现场
                visited[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }

}
