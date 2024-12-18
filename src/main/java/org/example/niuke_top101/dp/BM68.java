package org.example.niuke_top101.dp;

public class BM68 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum(int[][] matrix) {
        // write code here
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) {

                } else if (i == 0) {
                    matrix[i][j] += matrix[i][j - 1];
                } else if (j == 0) {
                    matrix[i][j] += matrix[i - 1][j];
                } else {
                    matrix[i][j] += Math.min(matrix[i][j - 1], matrix[i - 1][j]);
                }
            }
        }
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }
}
