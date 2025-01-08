package org.example.hot100.binary_search;

public class Question74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                col++;
            } else if (matrix[row][col] > target) {
                row--;
            }
        }
        return false;
    }
}
