package org.example.hot100.recall;

import java.util.ArrayList;
import java.util.List;

public class Question17 {
    public List<String> letterCombinations(String digits) {
        char[][] chars = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        StringBuilder builder = new StringBuilder();

        dfs(digits, chars, 0, res, builder);

        return res;
    }

    public void dfs(String digits, char[][] chars, int index, List<String> res, StringBuilder builder) {
        if (builder.length() >= digits.length()) {
            res.add(new String(builder));
            return;
        }

        char[] charList = chars[digits.charAt(index) - '2'];
        for (int j = 0; j < charList.length; j++) {
            builder.append(charList[j]);
            dfs(digits, chars, index + 1, res, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
