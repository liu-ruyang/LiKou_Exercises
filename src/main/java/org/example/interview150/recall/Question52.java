package org.example.interview150.recall;

import java.util.Arrays;

/**
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子
 * 快速判断每个位置是否可以放皇后：
 * ① 方向一的斜线为从左上到右下方向，同一条斜线上的每个位置满足行下标与列下标之差相等
 * ② 方向二的斜线为从右上到左下方向，同一条斜线上的每个位置满足行下标与列下标之和相等
 */
public class Question52 {
    int sum = 0;

    public static void main(String[] args) {
        new Question52().totalNQueens(4);
    }

    public int totalNQueens(int n) {
        sum = 0;
        boolean[] visited = new boolean[n]; // 记录列是否已有皇后
        boolean[] visited2 = new boolean[2 * n - 1];    // 记录所在对角线1是否已有皇后
        boolean[] visited3 = new boolean[2 * n - 1];    // 记录所在对角线2是否已有皇后
        Arrays.fill(visited, false);

        dfs(0, visited, visited2, visited3, n);
        return sum;
    }

    // 在第row行放一个，放的位置判断一下所在列是否已有皇后，返回可以有的方案数量
    public void dfs(int row, boolean[] visited, boolean[] visited2, boolean[] visited3, int n) {
        if (row == n) {
            sum++;
            return;
        }
        for (int i = 0; i < n; i++) {  // 遍历第row行的列
            if (!visited[i] && !visited2[i - row + n - 1] && !visited3[i + row]) {
                visited[i] = true;
                visited2[i - row + n - 1] = true;
                visited3[i + row] = true;
                dfs(row + 1, visited, visited2, visited3, n);
                visited[i] = false;
                visited2[i - row + n - 1] = false;
                visited3[i + row] = false;
            }
        }
    }
}
