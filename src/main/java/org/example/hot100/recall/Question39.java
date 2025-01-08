package org.example.hot100.recall;

import java.util.ArrayList;
import java.util.List;

public class Question39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, 0, res, 0, list);
        return res;
    }

    public void dfs(int[] candidates, int target, int index, List<List<Integer>> res, int sum, List<Integer> list) {
        if (index >= candidates.length) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] < target) {
                list.add(candidates[i]);
                dfs(candidates, target, i, res, sum + candidates[i], list);
                list.remove(list.size() - 1);
            } else if (sum + candidates[i] == target) {
                list.add(candidates[i]);
                res.add(new ArrayList<>(list));
                dfs(candidates, target, i + 1, res, sum + candidates[i], list);
                list.remove(list.size() - 1);
            }
        }
    }
}
