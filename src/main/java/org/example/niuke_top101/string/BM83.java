package org.example.niuke_top101.string;

import java.util.LinkedList;

public class BM83 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @param n int整型
     * @return string字符串
     */
    public String trans(String s, int n) {
        // write code here
        LinkedList<Character> stack = new LinkedList();
        StringBuilder res = new StringBuilder();
        int index = 0;
        while (index < n) {
            while (index < n && s.charAt(index) != ' ') {
                stack.push(s.charAt(index));
                index++;
            }

            while (!stack.isEmpty()) {
                res.append(stack.pop());
            }

            res.append(" ");
            if (index == n - 1 && s.charAt(index) == ' ')
                res.append(' ');
            index++;
        }

        res.reverse();

        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) != ' ') {
                if (res.charAt(i) >= 'a' && res.charAt(i) <= 'z') {
                    res.setCharAt(i, (char) (res.charAt(i) - 'a' + 'A'));
                } else {
                    res.setCharAt(i, (char) (res.charAt(i) - 'A' + 'a'));
                }
            }
        }

        return res.substring(1, res.length());
        // return res.toString();
    }
}
