package org.example.niuke_top101.recall;

import java.util.ArrayList;

public class BM55 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param num int整型一维数组
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        ArrayList<Integer> list = new ArrayList();
        dfs(res, list, num);
        return res;
    }

    public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int[] num) {
        if (list.size() == num.length) {
            res.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (!list.contains(num[i])) {
                list.add(num[i]);
                dfs(res, list, num);
                list.remove(list.size() - 1);
            }
        }
    }
}
