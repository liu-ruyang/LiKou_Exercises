package org.example.hot100.sliding_window;

import java.util.*;

public class Question438 {
    public static void main(String[] args) {
        new Question438().findAnagrams("cbaebabacd", "abc");
    }

    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> target = new HashMap<>();
        for (char c : p.toCharArray()) {
            if (!target.containsKey(c)) {
                target.put(c, 1);
            } else {
                target.put(c, target.get(c) + 1);
            }
        }

        HashMap<Character, Integer> record = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!target.containsKey(c)) {
                // record = new HashMap<>();
                record.clear(); // 可以优化空间复杂度，时间复杂度也有一定提升
                // 如果当前元素不是，那么结果只能在后面的位置开始
                left = i + 1;
            } else {
                // 当前元素满足条件，需要更新信息
                if (!record.containsKey(c)) {
                    record.put(c, 1);
                } else {
                    record.put(c, record.get(c) + 1);
                }

                if (i - left + 1 > p.length()) {    // 为了保持窗口只有p.length()个元素
                    record.put(s.charAt(left), record.get(s.charAt(left)) - 1);
                    left++;
                }
                // 判断当前窗口中字符串是否是字母异位词
                if (judge(record, target)) {
                    res.add(i - p.length() + 1);
                }

            }
        }

        return res;
    }

    public boolean judge(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        if (map1.size() != map2.size())
            return false;

        Set<Map.Entry<Character, Integer>> entries = map2.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (!map1.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }
    // public List<Integer> findAnagrams(String s, String p) {
    //     List<Integer> res = new ArrayList<>();
    //     int left = 0;
    //     int right = p.length() - 1;
    //     while (right < s.length()) {
    //         if (judge(s.substring(left, right + 1), p)) {
    //             res.add(left);
    //         }
    //         left++;
    //         right++;
    //     }
    //     return res;
    // }
    //
    // public boolean judge(String s, String p) {
    //     char[] ss = s.toCharArray();
    //     char[] pp = p.toCharArray();
    //     Arrays.sort(ss);
    //     Arrays.sort(pp);
    //     return new String(ss).equals(new String(pp));
    // }

}
