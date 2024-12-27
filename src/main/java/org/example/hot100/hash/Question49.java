package org.example.hot100.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Question49 {

    public static void main(String[] args) {
        String[] a = {"eat", "tea", "tan", "ate", "nat", "bat"};
        new Question49().groupAnagrams(a);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // 保存至哈希，键为字母重排序后的字符串
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String sortStr = sortStr(strs[i]);
            if (!map.containsKey(sortStr)) {    // Map比较字符串的时候使用的是equals()方法，而不是==，只需要字符串的内容相同即可
                map.put(sortStr, new ArrayList<>());
            }
            map.get(sortStr).add(strs[i]);
        }

        List<List<String>> res = new ArrayList<>();
        map.forEach((key, value) -> {
            res.add(value);
        });
        return res;
    }

    public String sortStr(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
