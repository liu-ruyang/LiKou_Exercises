package org.example.interview150.hash;

import java.util.HashMap;
import java.util.HashSet;

public class Question290 {
    public boolean wordPattern(String pattern, String s) {
        String[] t = s.split(" ");
        if (pattern.length() != t.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < pattern.toCharArray().length; i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (set.contains(t[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), t[i]);
                set.add(t[i]);
            } else {
                if (!map.get(pattern.charAt(i)).equals(t[i])) {
                    return false;
                }
            }
        }
        return true;

    }
}
