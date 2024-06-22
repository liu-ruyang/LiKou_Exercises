package org.example;

import java.util.*;

public class Question49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        new Question49().groupAnagrams(strs);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String sortStr = strSort(str);
            if (map.containsKey(sortStr)) {
                map.get(sortStr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortStr, list);
            }
        }

        List<List<String>> result = new ArrayList<>();
        Set<String> sortStrKeys = map.keySet();
        for (String sortStrKey : sortStrKeys) {
            List<String> list = map.get(sortStrKey);
            result.add(list);
        }
        return result;
    }

    // 对字符串进行排序，直接使用Arrays.sort工具排序
    public String strSort(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        // String string1 = chars.toString();
        String string1 = new String(chars);
        return string1;
    }

}
