package org.example.niuke_top101.recall;

public class BM61 {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] b = {{4, 3, 3, 6, 6, 3, 2, 1, 0, 7}, {1, 8, 2, 8, 5, 9, 2, 8, 3, 1}, {8, 0, 9, 2, 4, 3, 2, 4, 3, 7}, {1, 2, 2, 6, 3, 0, 3, 9, 7, 0}, {7, 4, 3, 8, 8, 3, 2, 4, 6, 8}, {2, 8, 9, 2, 9, 3, 0, 8, 7, 8}, {8, 9, 9, 4, 6, 3, 3, 4, 9, 6}, {2, 8, 3, 8, 1, 3, 7, 3, 0, 7}, {2, 1, 1, 6, 4, 1, 0, 8, 1, 6}, {4, 1, 3, 6, 3, 4, 4, 4, 0, 3}};
        // new BM61().solve(a);
        new BM61().solve(b);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 递增路径的最大长度
     *
     * @param matrix int整型二维数组 描述矩阵的每个数
     * @return int整型
     */
    public int solve(int[][] matrix) {
        // write code here
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(dfs(matrix, visited, i, j), res);
            }
        }
        return res;
    }

    public int dfs(int[][] matrix, boolean[][] visited, int x, int y) {
        int len = 1;
        int[][] step = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        visited[x][y] = true;
        for (int i = 0; i < step.length; i++) {
            int xx = x + step[i][0];
            int yy = y + step[i][1];
            if (xx >= 0 && xx < matrix.length && yy >= 0 && yy < matrix[0].length &&
                    !visited[xx][yy] && matrix[xx][yy] > matrix[x][y]) {
                len = Math.max(dfs(matrix, visited, xx, yy) + 1, len);
            }
        }
        visited[x][y] = false;
        return len;
    }
}
