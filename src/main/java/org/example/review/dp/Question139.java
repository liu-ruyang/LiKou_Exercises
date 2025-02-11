package org.example.review.dp;

import java.util.List;

public class Question139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (String string : wordDict) {
                if (i >= string.length() && s.substring(i - string.length() + 1, i + 1).equals(string)) {
                    if (dp[i - string.length()]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
