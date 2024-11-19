package org.example.interview150.recall;

import java.util.ArrayList;
import java.util.List;

public class Question17 {

    public static void main(String[] args) {
        new Question17().letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.equals("")) {
            return res;
        }

        char[] chars = digits.toCharArray();
        dfs(chars, 0, "", res);

        return res;

    }

    // 添加第 i 个数字对应的字符
    public void dfs(char[] chars, int i, String str, List<String> res) {
        if (i == chars.length) {
            res.add(str);
            return;
        }

        switch (chars[i] - '0') {
            case (2) -> {
                dfs(chars, i + 1, str + "a", res);
                dfs(chars, i + 1, str + "b", res);
                dfs(chars, i + 1, str + "c", res);
            }
            case (3) -> {
                dfs(chars, i + 1, str + "d", res);
                dfs(chars, i + 1, str + "e", res);
                dfs(chars, i + 1, str + "f", res);
            }
            case (4) -> {
                dfs(chars, i + 1, str + "g", res);
                dfs(chars, i + 1, str + "h", res);
                dfs(chars, i + 1, str + "i", res);
            }
            case (5) -> {
                dfs(chars, i + 1, str + "j", res);
                dfs(chars, i + 1, str + "k", res);
                dfs(chars, i + 1, str + "l", res);
            }
            case (6) -> {
                dfs(chars, i + 1, str + "m", res);
                dfs(chars, i + 1, str + "n", res);
                dfs(chars, i + 1, str + "o", res);
            }
            case (7) -> {
                dfs(chars, i + 1, str + "p", res);
                dfs(chars, i + 1, str + "q", res);
                dfs(chars, i + 1, str + "r", res);
                dfs(chars, i + 1, str + "s", res);
            }
            case (8) -> {
                dfs(chars, i + 1, str + "t", res);
                dfs(chars, i + 1, str + "u", res);
                dfs(chars, i + 1, str + "v", res);
            }
            case (9) -> {
                dfs(chars, i + 1, str + "w", res);
                dfs(chars, i + 1, str + "x", res);
                dfs(chars, i + 1, str + "y", res);
                dfs(chars, i + 1, str + "z", res);
            }
        }
    }
}
