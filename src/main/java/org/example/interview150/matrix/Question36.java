package org.example.interview150.matrix;

public class Question36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxs = new int[3][3][9];

        // 遍历矩阵
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int value = c - '0';
                    rows[i][value - 1]++;
                    columns[j][value - 1]++;
                    int i1 = (int) Math.ceil((i + 1) / 3.0);
                    int j1 = (int) Math.ceil((j + 1) / 3.0);
                    subboxs[i1 - 1][j1 - 1][value - 1]++;
                    if (rows[i][value - 1] > 1 || columns[j][value - 1] > 1 || subboxs[i1 - 1][j1 - 1][value - 1] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;

    }

}
