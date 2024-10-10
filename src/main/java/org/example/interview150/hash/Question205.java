package org.example.interview150.hash;

import java.util.HashMap;
import java.util.HashSet;

public class Question205 {
    public static void main(String[] args) {
        new Question205().isIsomorphic("badc", "baba");
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.toCharArray().length; i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (set.contains(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
                set.add(t.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;

    }
}
