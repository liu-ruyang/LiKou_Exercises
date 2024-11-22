package org.example.interview150.binary_search;

public class Question74 {
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     int xLeft = 0, xRight = matrix.length - 1, yLeft = 0, yRight = matrix.length - 1;
    //
    //     while (xLeft < xRight && yLeft < yRight) {
    //         int xMid = (xLeft + xRight) / 2;
    //         int yMid = (yLeft + yRight) / 2;
    //
    //     }
    // }

    public static void main(String[] args) {
        // int[][] a = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] a = {{1, 1}};
        new Question74().searchMatrix(a, 0);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length * matrix[0].length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            int[] pos = indexToPos(matrix, mid);
            if (matrix[pos[0]][pos[1]] == target) {
                return true;
            } else if (matrix[pos[0]][pos[1]] > target) {
                right = mid - 1;
            } else if (matrix[pos[0]][pos[1]] < target) {
                left = mid + 1;
            }
        }
        
        // 最后建议使用left，不要使用right，因为前面mid的计算都是向下取整，如果mid为0的时候，那么right=mid-1就有可能出现right=-1，出界的情况
        int[] pos = indexToPos(matrix, left);
        return matrix[pos[0]][pos[1]] == target;
    }

    // 形参分别是矩阵、一维形式下标
    public int[] indexToPos(int[][] matrix, int index) {
        int x = index / matrix[0].length;
        int y = index % matrix[0].length;
        return new int[]{x, y};
    }
}
