package org.example.hot100.sliding_window;

import java.util.HashSet;

public class Question3 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        int right = 0;
        HashSet<Character> set = new HashSet<>();
        char[] ss = s.toCharArray();
        while (right < s.length()) {
            if (right == 0) {
                set.add(ss[right]);
                right++;
                res = Math.max(right - left, res);
            } else {
                while (set.contains(ss[right])) {
                    set.remove(ss[left]);
                    left++;
                }
                set.add(ss[right]);
                res = Math.max(right - left + 1, res);
                right++;
                // if (s.charAt(right) == s.charAt(left)) {
                //     left++;
                //     right++;
                // } else {
                //     right++;
                //     res = Math.max(right - left, res);
                // }
            }
        }
        return res;
    }
}
