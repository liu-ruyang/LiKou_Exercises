package org.example.hot100.matrix;

public class Question73 {
    // 两次遍历矩阵，将需要置0的行和列反别存储在第0行和第0列
    public void setZeroes(int[][] matrix) {
        int flagRow0 = 0;
        int flagCol0 = 0;
        // 利用第0行和第0列记录信息
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
                if (i == 0 && matrix[i][j] == 0) {
                    // 标记第0行
                    flagRow0 = 1;
                }
                if (j == 0 && matrix[i][j] == 0) {
                    // 标记第0列
                    flagCol0 = 1;
                }
            }
        }

        // 从第1行第1列开始置0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 处理第0行
        if (flagRow0 == 1) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        // 处理第0列
        if (flagCol0 == 1) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // 利用两个HashSet
    // 时间复杂度O(nm)，空间复杂度O(n+m)
//    public void setZeroes(int[][] matrix) {
//        HashSet<Integer> row = new HashSet<>();
//        HashSet<Integer> column = new HashSet<>();
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                if (matrix[i][j] == 0) {
//                    row.add(i);
//                    column.add(j);
//                }
//            }
//        }
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                if (row.contains(i) || column.contains(j)) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//    }
}
