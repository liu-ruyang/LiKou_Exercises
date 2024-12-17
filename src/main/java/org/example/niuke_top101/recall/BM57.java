package org.example.niuke_top101.recall;

public class BM57 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 判断岛屿数量
     *
     * @param grid char字符型二维数组
     * @return int整型
     */
    int res;

    public int solve(char[][] grid) {
        // write code here
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    visited[i][j] = true;
                    dfs(grid, visited, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        int[][] step = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < step.length; i++) {
            int nextX = x + step[i][0];
            int nextY = y + step[i][1];
            if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length &&
                    grid[nextX][nextY] == '1' && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                dfs(grid, visited, nextX, nextY);
            }
        }
    }
}
