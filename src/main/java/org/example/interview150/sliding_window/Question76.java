package org.example.interview150.sliding_window;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Question76 {
    public static void main(String[] args) {
        // new Question76().minWindow("a", "a");
        // new Question76().minWindow("ADOBECODEBANC", "ABC");
        new Question76().minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd");
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (target.containsKey(t.charAt(i))) {
                target.put(t.charAt(i), target.get(t.charAt(i)) + 1);
            } else {
                target.put(t.charAt(i), 1);
            }
        }
        HashMap<Character, Integer> record = new HashMap<>();
        int res_left = 0;
        int res_right = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            while (right < s.length()) {
                if (target.containsKey(s.charAt(right))) {
                    if (!record.containsKey(s.charAt(right))) {
                        record.put(s.charAt(right), 1);
                    } else if (record.get(s.charAt(right)) < target.get(s.charAt(right))) {
                        record.put(s.charAt(right), record.get(s.charAt(right)) + 1);
                    } else if (record.get(s.charAt(right)) >= target.get(s.charAt(right))) {
                        record.put(s.charAt(right), record.get(s.charAt(right)) + 1);
                    }
                    if (record.size() >= target.size()) {
                        break;
                    }
                }

                right++;
            }

            while (left < right && !target.containsKey(s.charAt(left)) || left < right && target.containsKey(s.charAt(left)) && record.get(s.charAt(left)) > target.get(s.charAt(left))) {
                if (left < right && target.containsKey(s.charAt(left)) && record.get(s.charAt(left)) > target.get(s.charAt(left))) {
                    record.put(s.charAt(left), record.get(s.charAt(left)) - 1);
                }
                left++;
            }

            if (check(target, record)) {
                if (right - left < res_right - res_left) {
                    res_left = left;
                    res_right = right;
                }
            }
            right++;
        }

        if (res_right - res_left >= Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(res_left, res_right + 1);
    }

    public boolean check(HashMap<Character, Integer> target, HashMap<Character, Integer> record) {
        if (record.size() != target.size()) {
            return false;
        }
        Iterator<Map.Entry<Character, Integer>> iterator = target.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            if (record.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
    // public String minWindow(String s, String t) {
    //
    //     HashMap<Character, Integer> target = new HashMap<>();
    //     for (int i = 0; i < t.length(); i++) {
    //         if (target.containsKey(t.charAt(i))) {
    //             target.put(t.charAt(i), target.get(t.charAt(i)) + 1);
    //         } else {
    //             target.put(t.charAt(i), 1);
    //         }
    //     }
    //     HashMap<Character, Integer> record = new HashMap<>();
    //     int res_left = 0;
    //     int res_right = Integer.MAX_VALUE;
    //     int left = 0;
    //     int right = 0;
    //     while (right < s.length()) {
    //         // right右移直至遇到一个字符在t中
    //         while (right < s.length()) {
    //             if (target.containsKey(s.charAt(right))) {
    //                 if (!record.containsKey(s.charAt(right))) {
    //                     record.put(s.charAt(right), 1);
    //                     if (record.get(s.charAt(right)) >= target.get(s.charAt(right)))
    //                         break;
    //                 } else if (record.get(s.charAt(right)) < target.get(s.charAt(right))) {
    //                     record.put(s.charAt(right), record.get(s.charAt(right)) + 1);
    //                     if (record.get(s.charAt(right)) >= target.get(s.charAt(right)))
    //                         break;
    //                 } else if (record.get(s.charAt(right)) >= target.get(s.charAt(right))) {
    //                     record.put(s.charAt(right), record.get(s.charAt(right)) + 1);
    //                     break;
    //                 }
    //             }
    //             right++;
    //         }
    //
    //         // left如需右移，移至遇到一个字符在t中
    //         // while (left <= right){
    //         if (right < s.length() && (!record.containsKey(s.charAt(left)) || s.charAt(left) == s.charAt(right))) {
    //             record.put(s.charAt(left), record.get(s.charAt(left)) - 1);
    //             left++;
    //             while (left < right && !target.containsKey(s.charAt(left)) || left < right && target.containsKey(s.charAt(left)) && record.get(s.charAt(left)) > target.get(s.charAt(left))) {
    //                 if (left < right && target.containsKey(s.charAt(left)) && record.get(s.charAt(left)) > target.get(s.charAt(left))) {
    //                     record.put(s.charAt(left), record.get(s.charAt(left)) - 1);
    //                 }
    //                 left++;
    //             }
    //         }
    //
    //         if (right - left < res_right - res_left) {
    //             res_left = left;
    //             res_right = right;
    //         }
    //         right++;
    //         // }
    //     }
    //
    //     if (record.size() != target.size()) {
    //         return "";
    //     }
    //     Iterator<Map.Entry<Character, Integer>> iterator = target.entrySet().iterator();
    //     while (iterator.hasNext()) {
    //         Map.Entry<Character, Integer> entry = iterator.next();
    //         if (record.get(entry.getKey()) != entry.getValue()) {
    //             return "";
    //         }
    //     }
    //
    //     return s.substring(res_left, res_right + 1);
    // }
}
