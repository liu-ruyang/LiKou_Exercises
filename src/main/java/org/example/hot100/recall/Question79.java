package org.example.hot100.recall;

public class Question79 {
    public static void main(String[] args) {
        char[][] a = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        new Question79().exist(a, "SEE");
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean dfs = dfs(board, word, 0, i, j, visited);
                if (dfs) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int charIndex, int x, int y, boolean[][] visited) {
        if (charIndex >= word.length() - 1 && word.charAt(charIndex) == board[x][y]) {
            return true;
        }
        if (word.charAt(charIndex) != board[x][y]) {
            return false;
        }

        visited[x][y] = true;

        int[][] steps = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < steps.length; i++) {
            int newX = x + steps[i][0];
            int newY = y + steps[i][1];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && !visited[newX][newY]) {  // 新坐标合法
                boolean dfs = dfs(board, word, charIndex + 1, newX, newY, visited);
                if (dfs) {
                    return true;
                }
            }
        }
        visited[x][y] = false;


        return false;
    }
}
