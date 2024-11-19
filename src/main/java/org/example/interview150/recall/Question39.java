package org.example.interview150.recall;

import java.util.ArrayList;
import java.util.List;

public class Question39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < candidates.length; i++) {
            dfs(candidates, target, i, 0, list, res);
        }

        return res;
    }

    public void dfs(int[] candidates, int target, int index, int sum, ArrayList<Integer> list, List<List<Integer>> res) {
        list.add(candidates[index]);
        sum += candidates[index];

        if (sum > target) {
            list.remove(list.size() - 1);
            return;
        } else if (sum == target) {
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        // candidates 中的 同一个 数字可以 无限制重复被选取 ,所以 i 要从 index 开始遍历，不能小于 index ，也不能大于 index
        for (int i = index; i < candidates.length; i++) {
            dfs(candidates, target, i, sum, list, res);
        }

        list.remove(list.size() - 1);
    }
}
