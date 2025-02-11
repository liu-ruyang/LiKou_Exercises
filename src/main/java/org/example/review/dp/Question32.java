package org.example.review.dp;

import java.util.Arrays;

public class Question32 {
    public static void main(String[] args) {
        // new Question32().longestValidParentheses(")()())");
        // new Question32().longestValidParentheses("())");
        new Question32().longestValidParentheses("()(())");
    }

    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, 0);

        int res = 0;

        char[] ss = s.toCharArray();
        for (int i = 1; i < ss.length; i++) {
            if (ss[i] == ')') {
                if (ss[i - 1] == '(') {
                    dp[i + 1] = dp[i - 1] + 2;
                } else if (ss[i - 1] == ')' && i - dp[i] - 1 >= 0 && ss[i - dp[i] - 1] == '(') {
                    dp[i + 1] = dp[i] + 2;
                    if (i - dp[i] - 1 > 0) {
                        dp[i + 1] += dp[i - dp[i] - 1];
                    }
                }
                res = Math.max(res, dp[i + 1]);
            }
        }
        return res;
    }
}
