package org.example.hot100.sub_string;

import java.util.Arrays;

public class Question76 {
    public static void main(String[] args) {
        new Question76().minWindow("ADOBECODEBANC", "ABC");
    }

    public String minWindow(String s, String t) {
        int[] target = new int[52];
        Arrays.fill(target, 0);
        for (char c : t.toCharArray()) {
            target[c - 'A']++;
        }

        String res = s.repeat(2);

        int[] record = new int[52];
        Arrays.fill(record, 0);
        int left = 0, right = 0;
        while (right < s.length()) {
            record[s.charAt(right) - 'A']++;    // 记录右边界信息
            if (compare(record, target)) {  // 子串符合条件
                // 先判断是否需要移动左边界 -> 再判断是不是更优选择
                while (record[s.charAt(left) - 'A'] > target[s.charAt(left) - 'A']) {   // 如需要，移动左边界
                    record[s.charAt(left) - 'A']--;
                    left++;
                }
                if (right - left + 1 < res.length()) {  // 更短且符合条件的子串
                    res = s.substring(left, right + 1);
                }
            }
            right++;
        }
        return res.length() == s.length() * 2 ? "" : res;
    }

    public boolean compare(int[] record, int[] target) {
        for (int i = 0; i < target.length; i++) {
            // if (target[i] != 0 && target[i] <= record[i]) {
            if (target[i] > record[i]) {
                return false;
            }
        }
        return true;
    }
}
