package org.example.niuke_top101.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class BM56 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param num int整型一维数组
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        ArrayList<Integer> list = new ArrayList();
        Arrays.sort(num);   // 因为存在重复项，为了更好的处理，将数组先排序
        dfs(res, list, num);
        return res;
    }

    public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list,
                    int[] num) {
        if (list.size() == num.length) {
            ArrayList<Integer> list2 = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                list2.add(num[list.get(i)]);
            }
            res.add(list2);
            return;
        }
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < num.length; i++) {
            if (!list.contains(i) && !set.contains(num[i])) {
                list.add(i);
                set.add(num[i]);
                dfs(res, list, num);
                list.remove(list.size() - 1);
            }
        }
    }
}
