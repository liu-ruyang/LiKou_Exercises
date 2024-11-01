package org.example.graph;

import java.util.Scanner;

// 岛屿的周长：岛屿上所有的块连接的水域的块数 加上 岛屿的方块周围没有说也没有岛屿方块数
public class KaMa106_DFS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] graph = new int[n][m];
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    if (i - 1 < 0 || graph[i - 1][j] == 0) {
                        result++;
                    }
                    if (i + 1 >= graph.length || graph[i + 1][j] == 0) {
                        result++;
                    }
                    if (j - 1 < 0 || graph[i][j - 1] == 0) {
                        result++;
                    }
                    if (j + 1 >= graph[0].length || graph[i][j + 1] == 0) {
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
