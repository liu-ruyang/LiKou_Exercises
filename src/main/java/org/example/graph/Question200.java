package org.example.graph;

import java.util.LinkedList;

public class Question200 {
    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    res++;
                    // dfs(grid, visited, i, j);
                    bfs(grid, visited, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int[][] visited, int x, int y) {
        visited[x][y] = 1;

        if (y + 1 < grid[0].length && grid[x][y + 1] == '1' && visited[x][y + 1] == 0) {
            dfs(grid, visited, x, y + 1);
        }
        if (y - 1 >= 0 && grid[x][y - 1] == '1' && visited[x][y - 1] == 0) {
            dfs(grid, visited, x, y - 1);
        }
        if (x + 1 < grid.length && grid[x + 1][y] == '1' && visited[x + 1][y] == 0) {
            dfs(grid, visited, x + 1, y);
        }
        if (x - 1 >= 0 && grid[x - 1][y] == '1' && visited[x - 1][y] == 0) {
            dfs(grid, visited, x - 1, y);
        }
    }

    // 容易出现超时
    // 原因：标记节点访问过在从队列取出节点之后，这会导致很多节点重复添加进队列中
    // 解决：应当在节点添加进队列的时候，就标记该节点已经被访问
    public void bfs(char[][] grid, int[][] visited, int x, int y) {
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));

        while (!queue.isEmpty()) {
            Pair pair = queue.removeFirst();
            // visited[pair.x][pair.y] = 1;

            if (pair.y + 1 < grid[0].length && grid[pair.x][pair.y + 1] == '1' && visited[pair.x][pair.y + 1] == 0) {
                queue.add(new Pair(pair.x, pair.y + 1));
                visited[pair.x][pair.y + 1] = 1;
            }
            if (pair.y - 1 >= 0 && grid[pair.x][pair.y - 1] == '1' && visited[pair.x][pair.y - 1] == 0) {
                queue.add(new Pair(pair.x, pair.y - 1));
                visited[pair.x][pair.y - 1] = 1;
            }
            if (pair.x + 1 < grid.length && grid[pair.x + 1][pair.y] == '1' && visited[pair.x + 1][pair.y] == 0) {
                queue.add(new Pair(pair.x + 1, pair.y));
                visited[pair.x + 1][pair.y] = 1;
            }
            if (pair.x - 1 >= 0 && grid[pair.x - 1][pair.y] == '1' && visited[pair.x - 1][pair.y] == 0) {
                queue.add(new Pair(pair.x - 1, pair.y));
                visited[pair.x - 1][pair.y] = 1;
            }
        }
    }

    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
