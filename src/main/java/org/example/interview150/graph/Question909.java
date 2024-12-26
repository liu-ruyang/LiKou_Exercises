package org.example.interview150.graph;

import java.util.Arrays;
import java.util.LinkedList;

public class Question909 {
    public static void main(String[] args) {
//        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int[][] board = {{-1, -1}, {-1, 3}};
//        new Demo2().num2Pos(board, 1, 6);
//        new Demo2().num2Pos(board, 6, 6);
//        new Demo2().num2Pos(board, 3, 6);
//        new Demo2().num2Pos(board, 12, 6);
//        new Demo2().num2Pos(board, 10, 6);
//        new Demo2().num2Pos(board, 7, 6);
//        new Demo2().num2Pos(board, 36, 6);
//        new Demo2().num2Pos(board, 34, 6);
//        new Demo2().num2Pos(board, 31, 6);
//        new Demo2().num2Pos(board, 25, 6);
//        new Demo2().num2Pos(board, 27, 6);
//        new Demo2().num2Pos(board, 30, 6);
        new Question909().snakesAndLadders(board);
    }

    public int snakesAndLadders(int[][] board) {
        LinkedList<Integer> queue = new LinkedList<>();
        int n = board.length;
        int[] res = new int[n * n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        queue.add(0);
        while (!queue.isEmpty()) {
            Integer cur = queue.pop();
            for (int i = 1; i <= 6; i++) {
                if (cur + i > n * n) {
                    continue;
                }
                int steps = num2Pos(board, cur + i, n);

                if (steps == -1) {
                    if (res[cur] + 1 < res[cur + i]) {
                        res[cur + i] = res[cur] + 1;
                        queue.add(cur + i);
                    }
                } else {
                    // 有楼梯
                    if (res[cur] + 1 < res[steps]) {
                        res[steps] = res[cur] + 1;
                        queue.add(steps);
                    }
                }
            }
        }

        return res[n * n];
    }

    // num是1-n^2的序号，返回的是num对应到board二维矩阵中的位置的值
    public int num2Pos(int[][] board, int num, int n) {
        int row;
        int col;
        // 取整
        int num1 = num / n;
        // 取余
        int num2 = num % n;
        if (num2 == 0) {
//            if ((num1 & (-num1)) == 0) {    // n&(-n)得到位级表示中最低的那一位
            if (num1 % 2 == 0) {
                col = 1;
            } else {
                col = n;
            }
            row = n - (num1 - 1);
        } else {
            if (num1 % 2 == 0) {
                col = num2;
            } else {
                col = n - (num2 - 1);
            }
            row = n - num1;
        }

        row -= 1;
        col -= 1;
        if (col < 0) {
            System.out.println();
        }
        if (row < 0) {
            System.out.println();
        }

        return board[row][col];
    }
}
