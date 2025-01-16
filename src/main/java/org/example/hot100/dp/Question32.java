package org.example.hot100.dp;

import java.util.Arrays;
import java.util.LinkedList;

public class Question32 {
    public int longestValidParentheses(String s) {
        if (s.equals("") || s.length() == 1) return 0;
        LinkedList<Integer> stack = new LinkedList<>();     // 栈中存放的是每个字符的下标
        char[] chars = s.toCharArray();

        int res = 0;
        int[] dp = new int[s.length() + 1];         // dp[i]表示下标为 i-1 位置的符号最大有效括号的长度
        Arrays.fill(dp, 0);

        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty()) {  // 当前栈中为空
                stack.push(i);
            } else {
                if (chars[i] == '(') {  // 当前遍历的字符是'('
                    stack.push(i);
                } else {    // 当前遍历的字符是')'，需要和前面的字符匹配
                    if (chars[stack.peek()] == '(') {
                        Integer pop = stack.pop();
                        dp[i + 1] = dp[pop - 1 + 1] + i - pop + 1;
                        res = Math.max(res, dp[i + 1]);
//                        res = Math.max(res, i - pop + 1);
                    } else {    // 当前遍历的虽然是')'，但是栈顶元素不是'('
                        stack.push(i);
                    }
                }
            }
        }
        return res;
    }
}
