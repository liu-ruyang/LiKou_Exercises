package org.example.interview150.matrix;

import java.util.ArrayList;
import java.util.List;

public class Question54 {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        new Question54().spiralOrder(a);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int[][] flag = new int[matrix.length][matrix[0].length];
        // read(matrix, res, 0, matrix.length - 1, 0, matrix[0].length - 1);
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int columnStart = 0;
        int columnEnd = matrix[0].length - 1;
        while (columnEnd >= columnStart && rowEnd >= rowStart) {
            for (int j = columnStart; j <= columnEnd; j++) {
                if (flag[rowStart][j] == 0) {
                    res.add(matrix[rowStart][j]);
                    flag[rowStart][j] = 1;
                }
            }
            for (int i = rowStart + 1; i <= rowEnd; i++) {
                if (flag[i][columnEnd] == 0) {
                    res.add(matrix[i][columnEnd]);
                    flag[i][columnEnd] = 1;
                }
            }
            for (int j = columnEnd - 1; j >= columnStart; j--) {
                if (flag[rowEnd][j] == 0) {
                    res.add(matrix[rowEnd][j]);
                    flag[rowEnd][j] = 1;
                }
            }
            for (int i = rowEnd - 1; i >= rowStart + 1; i--) {
                if (flag[i][columnStart] == 0) {
                    res.add(matrix[i][columnStart]);
                    flag[i][columnStart] = 1;
                }
            }
            rowStart += 1;
            rowEnd -= 1;
            columnStart += 1;
            columnEnd -= 1;
        }
        return res;
    }

    public void read(int[][] matrix, List<Integer> res, int rowStart, int rowEnd, int columnStart, int columnEnd) {
        for (int j = columnStart; j <= columnEnd; j++) {
            res.add(matrix[rowStart][j]);
        }
        for (int i = rowStart + 1; i <= rowEnd; i++) {
            res.add(matrix[i][columnEnd]);
        }
        for (int j = columnEnd - 1; j >= columnStart; j--) {
            res.add(matrix[rowEnd][j]);
        }
        for (int i = rowEnd - 1; i >= rowStart + 1; i--) {
            res.add(matrix[i][columnStart]);
        }

        read(matrix, res, rowStart + 1, rowEnd - 1, columnStart + 1, columnEnd - 1);

    }


}
