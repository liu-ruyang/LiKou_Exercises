package org.example.interview150.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question212 {
    boolean[][] visited;
    List<String> res;

    public List<String> findWords(char[][] board, String[] words) {

        visited = new boolean[board.length][board[0].length];
        for (boolean[] booleans : visited) {
            Arrays.fill(booleans, false);
        }
        res = new ArrayList<>();

        // 构建字典树
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        // 遍历网格
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (trie.children[board[i][j] - 'a'] != null) {
                    visited[i][j] = true;
                    dfs(board, i, j, "", trie.children[board[i][j] - 'a']);
                    visited[i][j] = false;
                }
            }
        }

        return res;

    }

    // 去遍历[x, y]四周的字符
    public void dfs(char[][] board, int x, int y, String str, Trie trie) {
        if (trie.isEnd && !res.contains(str + trie.ch)) {
            res.add(str + trie.ch);
        }

        int[][] steps = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (int[] step : steps) {
            int nextX = x + step[0];
            int nextY = y + step[1];
            // [nextX, nextY]位置是否可以访问
            if (nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length && !visited[nextX][nextY]) {
                if (trie.children[board[nextX][nextY] - 'a'] != null) {
                    visited[nextX][nextY] = true;
                    dfs(board, nextX, nextY, str + trie.ch, trie.children[board[nextX][nextY] - 'a']);
                    visited[nextX][nextY] = false;
                }

            }
        }
    }

    class Trie {
        char ch;
        Trie[] children;
        boolean isEnd;

        public Trie() {
            children = new Trie[26];    // 表示26个英文字母
            Arrays.fill(children, null);
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Trie[] children = node.children;
                if (children[c - 'a'] != null) {
                    node = children[c - 'a'];
                } else {
                    children[c - 'a'] = new Trie();
                    node = children[c - 'a'];
                    node.ch = c;
                }
                if (i == word.length() - 1) {   // 需要放到外面，以防已经word之前是前缀，但还不算是单词
                    node.isEnd = true;
                }
            }
        }
    }
}
