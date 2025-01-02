package org.example.hot100.matrix;

public class Question240 {
    public static void main(String[] args) {
//        int[][] a = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int[][] a = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
//        int[][] a = {{1, 1}};
//        int[][] a = {{1, 3, 5}};
        new Question240().searchMatrix(a, 5);
//        new Question240().searchMatrix(a, 20);
//        new Question240().searchMatrix(a, 2);
    }

    // 采用分治法
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        boolean res = dfs(matrix, target, left, right, top, bottom);

        return res;
    }

    public boolean dfs(int[][] matrix, int target, int left, int right, int top, int bottom) {
        if (left > right || top > bottom || left == right && top == bottom && matrix[top][left] != target) {
            return false;
        }
        int midRow = (top + bottom) / 2;
        int midCol = (left + right) / 2;

        if (matrix[midRow][midCol] == target) { // 找到了
            return true;
        }

//        if (matrix[midRow][midCol] > target) {  // 左上角
//            return dfs(matrix, target, left, midCol, top, midRow);
//        }
        boolean r1 = dfs(matrix, target, left, midCol, top, midRow);
        if (r1) {
            return r1;
        }
        boolean r2 = dfs(matrix, target, midCol + 1, right, top, midRow);// 右上角
        if (r2) {
            return r2;
        }
        boolean r3 = dfs(matrix, target, left, midCol, midRow + 1, bottom);// 左下角
        if (r3) {
            return r3;
        }
        boolean r4 = dfs(matrix, target, midCol + 1, right, midRow + 1, bottom);// 右下角
        return r4;
//        return r1 || r2 || r3 || r4;
    }
}
