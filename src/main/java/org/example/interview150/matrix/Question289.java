package org.example.interview150.matrix;

public class Question289 {
    public static void main(String[] args) {
        int[][] a = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        int[][] b = {{0, 0}};
        new Question289().gameOfLife(b);
    }

    public void gameOfLife(int[][] board) {
        int[][] copy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, board[i].length);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int live = getLive(copy, i, j);
                if (live == 2 && board[i][j] == 1) {
                    board[i][j] = 1;
                } else if (live == 3) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    public int getLive(int[][] board, int i, int j) {
        int count = 0;
        if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 1) {
            count++;
        }
        if (i - 1 >= 0 && board[i - 1][j] == 1) {
            count++;
        }
        if (i - 1 >= 0 && j + 1 <= board[0].length - 1 && board[i - 1][j + 1] == 1) {
            count++;
        }
        if (j - 1 >= 0 && board[i][j - 1] == 1) {
            count++;
        }
        if (j + 1 <= board[0].length - 1 && board[i][j + 1] == 1) {
            count++;
        }
        if (i + 1 <= board.length - 1 && j - 1 >= 0 && board[i + 1][j - 1] == 1) {
            count++;
        }
        if (i + 1 <= board.length - 1 && board[i + 1][j] == 1) {
            count++;
        }
        if (i + 1 <= board.length - 1 && j + 1 <= board[0].length - 1 && board[i + 1][j + 1] == 1) {
            count++;
        }
        return count;
    }
}
