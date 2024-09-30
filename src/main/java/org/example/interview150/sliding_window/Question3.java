package org.example.interview150.sliding_window;

import java.util.HashMap;

public class Question3 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            if (!map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), right);
                right++;
                res = Integer.max(res, right - left);
            } else {
                int index = map.get(right);
                if (index < left) {
                    map.put(s.charAt(right), right);
                    right++;
                    res = Integer.max(res, right - left);
                } else {
                    left = index + 1;
                    map.put(s.charAt(right), right);
                    right++;
                    res = Integer.max(res, right - left);
                }
            }
        }
        return res;
    }
}
