package org.example.interview150.graph;

import java.util.Arrays;

public class Question130 {

    public static void main(String[] args) {
        // char[][] a = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        // char[][] a = {{'X', 'O', 'X'}, {'O', 'X', 'O'}, {'X', 'O', 'X'}};
        char[][] a = {{'X', 'O', 'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'X'}, {'X', 'O', 'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'X'}};
        new Question130().solve(a);
    }

    public void solve(char[][] board) {

        int[][] visited = new int[board.length][board[0].length];
        for (int[] ints : visited) {
            Arrays.fill(ints, 0);
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                visited[i][0] = 1;
                bfs(board, i, 0, visited);
            }
            if (board[i][board[0].length - 1] == 'O') {
                visited[i][board[0].length - 1] = 1;
                bfs(board, i, board[0].length - 1, visited);
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                visited[0][j] = 1;
                bfs(board, 0, j, visited);
            }
            if (board[board.length - 1][j] == 'O') {
                visited[board.length - 1][j] = 1;
                bfs(board, board.length - 1, j, visited);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O' && visited[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void bfs(char[][] board, int curX, int curY, int[][] visitd) {
        // public void bfs(char[][] board, int curX, int curY) {
        int[][] actions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] action : actions) {
            int newX = curX + action[0];
            int newY = curY + action[1];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                if (board[newX][newY] == 'O') {
                    if (board[newX][newY] == 'O' && visitd[newX][newY] == 0) {
                        visitd[newX][newY] = 1;
                        board[newX][newY] = 'X';
                        bfs(board, newX, newY, visitd);
                        // bfs(board, newX, newY);
                    }
                }
            }
        }
    }
}
