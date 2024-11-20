package org.example.interview150.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用1代表'('，-1代表')'，则任意位置的前缀和都要大于等于0（非负）
 */
public class Question22 {
    public List<String> generateParenthesis(int n) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        int[] sum = new int[2 * n]; // 前缀和
        sum[0] = 1;
        list.add(1);
        int count = 1;  // 记录'('使用数量
        dfs(sum, 1, count, n, list, lists);

        ArrayList<String> res = new ArrayList<>();
        for (List<Integer> integers : lists) {
            StringBuffer buffer = new StringBuffer();
            for (Integer num : integers) {
                buffer.append(num == 1 ? "(" : ")");
            }
            res.add(buffer.toString());
        }
        return res;
    }

    // 计算至index的前缀和
    public void dfs(int[] sum, int index, int count, int n, List<Integer> list, List<List<Integer>> lists) {
        if (index == n * 2) {
            lists.add(new ArrayList(list));
            return;
        }
        if (sum[index - 1] - 1 >= 0) {
            // 放')'
            sum[index] = sum[index - 1] - 1;
            list.add(-1);
            dfs(sum, index + 1, count, n, list, lists);
            list.remove(list.size() - 1);
        }

        if (count < n) {
            // 放'('
            sum[index] = sum[index - 1] + 1;
            list.add(1);
            dfs(sum, index + 1, count + 1, n, list, lists);
            list.remove(list.size() - 1);
        }
    }
}
