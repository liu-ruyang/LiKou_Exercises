package org.example.hot100.matrix;

import java.util.ArrayList;
import java.util.List;

public class Question54 {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        new Question54().spiralOrder(a);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int colLeft = 0;
        int colRight = matrix[0].length - 1;
        int rowTop = 0;
        int rowBottom = matrix.length - 1;

        List<Integer> res = new ArrayList<Integer>();

        while (colLeft <= colRight || rowTop <= rowBottom) {
            for (int i = colLeft; i <= colRight && rowTop <= rowBottom; i++) {
                res.add(matrix[rowTop][i]);
            }
            rowTop++;
            for (int i = rowTop; i <= rowBottom && colLeft <= colRight; i++) {
                res.add(matrix[i][colRight]);
            }
            colRight--;
            for (int i = colRight; i >= colLeft && rowTop <= rowBottom; i--) {
                res.add(matrix[rowBottom][i]);
            }
            rowBottom--;
            for (int i = rowBottom; i >= rowTop && colLeft <= colRight; i--) {
                res.add(matrix[i][colLeft]);
            }
            colLeft++;
        }

        return res;
    }
}
