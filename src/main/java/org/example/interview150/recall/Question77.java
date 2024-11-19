package org.example.interview150.recall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question77 {

    public static void main(String[] args) {
        new Question77().combine(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            dfs(n, i, k, list, res);
        }
        return res;
    }

    // 向list中添加一个数，是否达到k个数
    public void dfs(int n, int start, int k, List<Integer> list, List<List<Integer>> res) {
        list.add(start);
        if (list.size() == k) {
            // List<Integer> dest = new ArrayList<>(list.size());
            List<Integer> dest = new ArrayList<>(Collections.nCopies(list.size(), 0));
            Collections.copy(dest, list);
            res.add(dest);
            list.remove(list.size() - 1);
            return;
        }

        for (int i = start + 1; i <= n; i++) {
            dfs(n, i, k, list, res);
        }

        list.remove(list.size() - 1);
    }
}
