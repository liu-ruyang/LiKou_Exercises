package org.example.hot100.recall;

import java.util.ArrayList;
import java.util.List;

public class Question22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        dfs(n, 0, 0, res, builder);
        return res;
    }

    public void dfs(int n, int numLeft, int numRight, List<String> res, StringBuilder builder) {
        if (numLeft < numRight || numLeft > n) {
            return;
        }
        if (numLeft == n && numRight == n) {
            res.add(new String(builder));
            return;
        }

        if (numLeft < n) {
            builder.append("(");
            dfs(n, numLeft + 1, numRight, res, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append(")");
            dfs(n, numLeft, numRight + 1, res, builder);
            builder.deleteCharAt(builder.length() - 1);
        } else if (numLeft == n) {
            builder.append(")");
            dfs(n, numLeft, numRight + 1, res, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
