package org.example.interview150.recall;

import java.util.Arrays;

public class Question79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (boolean[] booleans : visited) {
            Arrays.fill(booleans, false);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean found = dfs(board, i, j, word, 0, visited);
                if (found) return found;
            }
        }
        return false;
    }

    // 判断[x, y]位置和字符串的index位置字符是否相等
    public boolean dfs(char[][] board, int x, int y, String word, int index, boolean[][] visited) {
        if (index == word.length() - 1) {
            return word.charAt(index) == board[x][y];
        }
        int[][] steps = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        if (board[x][y] == word.charAt(index)) {
            visited[x][y] = true;
            for (int[] step : steps) {
                int newX = x + step[0];
                int newY = y + step[1];
                if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && !visited[newX][newY]) {
                    boolean found = dfs(board, newX, newY, word, index + 1, visited);
                    if (found) return found;
                }
            }
            visited[x][y] = false;
        }
        return false;
    }
}
