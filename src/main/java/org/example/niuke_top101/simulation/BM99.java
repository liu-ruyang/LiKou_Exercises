package org.example.niuke_top101.simulation;

public class BM99 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param mat int整型二维数组
     * @param n   int整型
     * @return int整型二维数组
     */
    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = mat.length - 1;
        int colEnd = mat[0].length - 1;

        while (rowStart < rowEnd) {
            for (int i = 0; i < colEnd - colStart; i++) {
                int tmp = mat[rowStart][colStart + i];
                mat[rowStart][colStart + i] = mat[rowEnd - i][colStart];
                mat[rowEnd - i][colStart] = mat[rowEnd][colEnd - i];
                mat[rowEnd][colEnd - i] = mat[rowStart + i][colEnd];
                mat[rowStart + i][colEnd] = tmp;
            }
            rowStart++;
            colStart++;
            rowEnd--;
            colEnd--;
        }
        return mat;
    }
}
