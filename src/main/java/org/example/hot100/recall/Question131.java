package org.example.hot100.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question131 {
    public static void main(String[] args) {
        new Question131().partition("aab");
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int[][] dp = new int[s.length()][s.length()];
        for (int[] ints : dp) {
            Arrays.fill(ints, 0);
        }

        dfs(s, 0, 0, dp, res, list);
        return res;
    }

    // dp[i][j]：0表示未标记，1表示是回文串，2表示不是回文串
    public void dfs(String s, int left, int right, int[][] dp, List<List<String>> res, List<String> list) {
        if (right >= s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = right; i < s.length(); i++) {
            if (dp[left][i] == 0) {
                boolean judge = judge(s, left, i);
                if (judge) {
                    dp[left][i] = 1;
                    list.add(s.substring(left, i + 1));
                    dfs(s, i + 1, i + 1, dp, res, list);
                    list.remove(list.size() - 1);
                }
            } else if (dp[left][i] == 1) {
                list.add(s.substring(left, i + 1));
                dfs(s, i + 1, i + 1, dp, res, list);
                list.remove(list.size() - 1);
            } else if (dp[left][i] == 2) {
                // 不操作
            }
        }
    }

    public boolean judge(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
