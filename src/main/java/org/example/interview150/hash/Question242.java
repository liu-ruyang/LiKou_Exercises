package org.example.interview150.hash;

import java.util.HashMap;

public class Question242 {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            } else {
                if (map.get(c) == 0) {
                    return false;
                } else {
                    map.put(c, map.get(c) - 1);
                }
            }
        }
        for (Character c : map.keySet()) {
            Integer n = map.get(c);
            if (n != 0) {
                return false;
            }
        }

        return true;

    }
}
