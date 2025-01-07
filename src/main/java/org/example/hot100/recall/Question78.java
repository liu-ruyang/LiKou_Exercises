package org.example.hot100.recall;

import java.util.ArrayList;
import java.util.List;

public class Question78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums, 0, res, list);
        return res;
    }

    public void dfs(int[] nums, int startIndex, List<List<Integer>> res, List<Integer> list) {
        if (startIndex >= nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[startIndex]);     // 添加当前元素
        dfs(nums, startIndex + 1, res, list);
        list.remove(list.size() - 1);   // 不添加当前元素
        dfs(nums, startIndex + 1, res, list);
    }
}
