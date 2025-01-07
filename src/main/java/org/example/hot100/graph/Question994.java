package org.example.hot100.graph;

import java.util.LinkedList;

public class Question994 {
    public static void main(String[] args) {
        int[][] a = {{1, 2}};
        new Question994().orangesRotting(a);
    }

    public int orangesRotting(int[][] grid) {
        LinkedList<Pair> queue = new LinkedList<>();
        // 寻找初始时的烂橘子
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
            }
        }
        int count = queue.size();
        boolean flag = count > 0; // 初始状态有无烂橘子
        int res = 0;
        int[][] action = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            while (count > 0) {
                Pair pop = queue.pop();
                for (int i = 0; i < action.length; i++) {
                    int newX = pop.x + action[i][0];
                    int newY = pop.y + action[i][1];
                    if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length) {
                        if (grid[newX][newY] == 1) {        // 相邻有新鲜橘子
                            grid[newX][newY] = 2;
                            queue.add(new Pair(newX, newY));
                        }
                    }
                }
                count--;
                if (count == 0) {
                    res++;      // 如果初始状态有烂橘子，最终res会比结果大1；如果初始状态没有烂橘子，则res就是结果，最后不用-1
                    count = queue.size();
                }
            }
        }

        // 检查是否还有新鲜橘子
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return flag ? res - 1 : res;

    }

    class Pair {
        int x, y;

        public Pair() {

        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
