package org.example.niuke_top101.recall;

import java.util.ArrayList;

public class BM60 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param n int整型
     * @return string字符串ArrayList
     */
    public ArrayList<String> generateParenthesis(int n) {
        // write code here
        // ‘(’视为1，‘)’视为-1，题目转换为“任意位置前缀和大于等于0”
        ArrayList<String> res = new ArrayList();
        ArrayList<Integer> list = new ArrayList();
        dfs(res, list, n, 0, 0);
        return res;
    }

    public void dfs(ArrayList<String> res, ArrayList<Integer> list, int n,
                    int numLeft, int preSum) {
        if (list.size() == n * 2) {
            StringBuilder strBuilder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                strBuilder.append(list.get(i) == 1 ? "(" : ")");
            }
            res.add(strBuilder.toString());
            return;
        }
        if (numLeft < n) {
            list.add(1);
            dfs(res, list, n, numLeft + 1, preSum + 1);
            list.remove(list.size() - 1);
        }
        if (preSum > 0) {
            list.add(-1);
            dfs(res, list, n, numLeft, preSum - 1);
            list.remove(list.size() - 1);
        }
    }
}
