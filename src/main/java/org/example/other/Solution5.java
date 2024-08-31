package org.example.other;

public class Solution5 {

    public int minPathCost(int[][] grid, int[][] moveCost) {
        for (int i = grid.length - 2; i >= 0; i--) {    // 倒序逐行处理
            calculateNextRow(grid, moveCost, i);
        }
        int min = Integer.MAX_VALUE / 2;
        for (int i = 0; i < grid[0].length; i++) {
            min = Math.min(grid[0][i], min);    // 使用静态方法取最小值
        }
        return min;
    }

    public void calculateNextRow(int[][] grid, int[][] moveCost, int rowIndex) {
        int m = grid[0].length;
        for (int i = 0; i < m; i++) {   // 遍历第 rowIndex 行
            int min = Integer.MAX_VALUE / 2;
            int temp;
            for (int j = 0; j < m; j++) {   // 遍历第 rowIndex + 1 行
                temp = grid[rowIndex][i] + grid[rowIndex + 1][j] + moveCost[grid[rowIndex][i]][j];
                min = temp < min ? temp : min;
            }
            grid[rowIndex][i] = min;
        }
    }

}
