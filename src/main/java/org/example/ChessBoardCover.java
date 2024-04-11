package org.example;

import java.util.Random;

/**
 * "棋盘覆盖"算法思路：https://blog.csdn.net/SongXJ_01/article/details/112439322
 */
public class ChessBoardCover {

    static int color = 1;

    public static void main(String[] args) {
        Random random = new Random();
        int k = random.nextInt(6);        // 生成一个0到5之间的随机整数
        int size = (int) Math.pow(2, k);
        int[][] board = new int[size][size];
        int dr = random.nextInt(size);
        int dc = random.nextInt(size);
        chessBoard(board, 0, 0, dr, dc, size);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("\t" + board[i][j]);
            }
            System.out.println();
        }

    }

    // 棋盘覆盖

    /**
     * @param board 棋盘（二维数组）
     * @param tr    棋盘坐上角横坐标
     * @param tc    棋盘左上角纵坐标
     * @param dr    特殊方块的位置的横坐标
     * @param dc    特殊方块的位置的纵坐标
     * @param size  子棋盘的边长大小
     */
    public static void chessBoard(int[][] board, int tr, int tc, int dr, int dc, int size) {
        int rHalfPos = size / 2 + (tr - 1);     // 左上子棋盘的右下角横坐标
        int cHalfPos = size / 2 + (tc - 1);     // 左上子棋盘的右下角纵坐标

        // 棋盘中只有一个方格
        if (rHalfPos < tr || cHalfPos < tc) {
            return;
        }

        // 特殊点 在 左上子棋盘
        if (dr <= rHalfPos && dc <= cHalfPos) {
            paint(board, rHalfPos + 1, cHalfPos);
            paint(board, rHalfPos, cHalfPos + 1);
            paint(board, rHalfPos + 1, cHalfPos + 1);
            color++;

            chessBoard(board, tr, tc, dr, dc, size / 2);                                // 左上子棋盘
            chessBoard(board, tr, cHalfPos + 1, rHalfPos, cHalfPos + 1, size / 2);                  // 右上子棋盘
            chessBoard(board, rHalfPos + 1, tc, rHalfPos + 1, cHalfPos, size / 2);                  // 左下子棋盘
            chessBoard(board, rHalfPos + 1, cHalfPos + 1, rHalfPos + 1, cHalfPos + 1, size / 2);     // 右下子棋盘
        }
        // 特殊点 在 左下子棋盘
        if (dr > rHalfPos && dc <= cHalfPos) {
            paint(board, rHalfPos, cHalfPos);
            paint(board, rHalfPos, cHalfPos + 1);
            paint(board, rHalfPos + 1, cHalfPos + 1);
            color++;

            chessBoard(board, tr, tc, rHalfPos, cHalfPos, size / 2);                                // 左上子棋盘
            chessBoard(board, tr, cHalfPos + 1, rHalfPos, cHalfPos + 1, size / 2);                  // 右上子棋盘
            chessBoard(board, rHalfPos + 1, tc, dr, dc, size / 2);                  // 左下子棋盘
            chessBoard(board, rHalfPos + 1, cHalfPos + 1, rHalfPos + 1, cHalfPos + 1, size / 2);     // 右下子棋盘
        }
        // 特殊点 在 右上子棋盘
        if (dr <= rHalfPos && dc > cHalfPos) {
            paint(board, rHalfPos, cHalfPos);
            paint(board, rHalfPos + 1, cHalfPos);
            paint(board, rHalfPos + 1, cHalfPos + 1);
            color++;

            chessBoard(board, tr, tc, rHalfPos, cHalfPos, size / 2);                                // 左上子棋盘
            chessBoard(board, tr, cHalfPos + 1, dr, dc, size / 2);                  // 右上子棋盘
            chessBoard(board, rHalfPos + 1, tc, rHalfPos + 1, cHalfPos, size / 2);                  // 左下子棋盘
            chessBoard(board, rHalfPos + 1, cHalfPos + 1, rHalfPos + 1, cHalfPos + 1, size / 2);     // 右下子棋盘
        }
        // 特殊点 在 右下子棋盘
        if (dr > rHalfPos && dc > cHalfPos) {
            paint(board, rHalfPos, cHalfPos);
            paint(board, rHalfPos + 1, cHalfPos);
            paint(board, rHalfPos, cHalfPos + 1);
            color++;

            chessBoard(board, tr, tc, rHalfPos, cHalfPos, size / 2);                                // 左上子棋盘
            chessBoard(board, tr, cHalfPos + 1, rHalfPos, cHalfPos + 1, size / 2);                  // 右上子棋盘
            chessBoard(board, rHalfPos + 1, tc, rHalfPos + 1, cHalfPos, size / 2);                  // 左下子棋盘
            chessBoard(board, rHalfPos + 1, cHalfPos + 1, dr, dc, size / 2);     // 右下子棋盘
        }

    }

    /**
     * 给棋盘上色
     *
     * @param board 棋盘
     * @param row   要上色的位置的横坐标
     * @param col   要上色的位置的纵坐标
     */
    public static void paint(int[][] board, int row, int col) {
        board[row][col] = color;
    }
}