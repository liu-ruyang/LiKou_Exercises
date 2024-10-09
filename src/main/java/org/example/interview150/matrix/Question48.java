package org.example.interview150.matrix;

public class Question48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int columnStart = 0;
        int columnEnd = matrix[0].length - 1;

        while (rowStart < rowEnd) {
            for (int j = columnStart; j < columnEnd; j++) {
                int temp = matrix[rowStart][j];
                matrix[rowStart][j] = matrix[n - j][columnStart];
                matrix[n - j][columnStart] = matrix[rowEnd][n - j];
                matrix[rowEnd][n - j] = matrix[j][columnEnd];
                matrix[j][columnEnd] = temp;
            }
            rowStart++;
            rowEnd--;
            columnStart++;
            columnEnd--;
        }
    }
}
