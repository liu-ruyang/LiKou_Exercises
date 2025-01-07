package org.example.hot100.graph;

public class Question200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int x, int y) {
        int[][] action = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < action.length; i++) {
            int newX = x + action[i][0];
            int newY = y + action[i][1];
            if (newX >= 0 && newX <= grid.length - 1 && newY >= 0 && newY <= grid[0].length - 1) {
                if (grid[newX][newY] == '1') {
                    grid[newX][newY] = '0';
                    dfs(grid, newX, newY);
                }
            }
        }
    }
}
