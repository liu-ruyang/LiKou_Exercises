package org.example.interview150.hash;

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
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            // String string = chars.toString();
            String string = String.valueOf(chars);
            if (map.containsKey(string)) {
                map.get(string).add(str);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(string, list);
            }
        }

        List<List<String>> res = new ArrayList<>();
        map.forEach((a, b) -> {
            res.add(b);
        });

        return res;
    }
}
