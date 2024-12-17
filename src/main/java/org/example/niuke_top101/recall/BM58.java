package org.example.niuke_top101.recall;

import java.util.ArrayList;
import java.util.HashSet;

public class BM58 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串
     * @return string字符串ArrayList
     */
    public ArrayList<String> Permutation(String str) {
        // write code here
        ArrayList<String> res = new ArrayList();
        ArrayList<Integer> list = new ArrayList();
        char[] strs = str.toCharArray();
        dfs(res, list, strs);
        return res;
    }

    public void dfs(ArrayList<String> res, ArrayList<Integer> list,
                    char[] strs) {
        if (list.size() == strs.length) {
            StringBuilder strBuilder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                strBuilder.append(strs[list.get(i)]);
            }
            res.add(strBuilder.toString());
            return;
        }
        HashSet<Character> set = new HashSet();
        for (int i = 0; i < strs.length; i++) {
            if (!list.contains(i) && !set.contains(strs[i])) {
                list.add(i);
                set.add(strs[i]);
                dfs(res, list, strs);
                list.remove(list.size() - 1);
            }
        }
    }
}
