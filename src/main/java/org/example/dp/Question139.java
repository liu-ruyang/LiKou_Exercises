package org.example.dp;

import java.util.List;


/**
 * 1. 确定dp数组及下标含义
 * 2. 确定递推公式
 * 3. dp数组如何初始化
 * 4. 确定遍历顺序
 * 5. 举例推导dp数组
 */
public class Question139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = false;
        }

        for (int i = 1; i <= s.length(); i++) { // 先遍历背包
            for (String word : wordDict) {  // 再遍历物品(字典)
                if (i >= word.length()) {
                    dp[i] = dp[i - word.length()] && s.substring(i - word.length(), i).equals(word);
                    if (dp[i])
                        break;
                }
            }
        }

        return dp[s.length()];

    }
}
