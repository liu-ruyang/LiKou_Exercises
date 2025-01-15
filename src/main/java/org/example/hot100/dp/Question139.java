package org.example.hot100.dp;

import java.util.Arrays;
import java.util.List;

public class Question139 {
    public static void main(String[] args) {
        new Question139().wordBreak("leetcode", Arrays.asList("leet", "code"));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                if (i >= wordDict.get(j).length()) {    // 当前的遍历的字符串的长度 小于等于 要拼接的字符串的长度
                    dp[i] = dp[i - wordDict.get(j).length()] && s.substring(i - 1 - wordDict.get(j).length() + 1, i).equals(wordDict.get(j));
                    if (dp[i]) {
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
