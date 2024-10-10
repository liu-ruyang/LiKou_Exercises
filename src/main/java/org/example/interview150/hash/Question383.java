package org.example.interview150.hash;

import java.util.HashMap;

public class Question383 {
    public static void main(String[] args) {
        new Question383().canConstruct("aa", "aab");
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        // HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            } else {
                Integer i = map.get(c);
                if (i == 0) {
                    return false;
                } else {
                    map.put(c, i - 1);
                }
            }
        }
        return true;
    }
}
