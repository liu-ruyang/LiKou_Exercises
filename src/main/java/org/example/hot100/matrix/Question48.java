package org.example.hot100.matrix;

public class Question48 {
    public void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while (left < right) {
            for (int i = left; i < right; i++) {
                int temp = matrix[top][i];
                matrix[top][i] = matrix[bottom - (i - left)][left];
                matrix[bottom - (i - left)][left] = matrix[bottom][right - (i - left)];
                matrix[bottom][right - (i - left)] = matrix[i][right];
                matrix[i][right] = temp;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
    }
}
