package org.example.graph;

import java.util.Scanner;

public class KaMa102_DFS {
    static int count;

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

        for (int i = 0; i < n; i++) {
            if (graph[i][0] == 1 && visited[i][0] == 0) {
                dfs(graph, visited, i, 0, false);
            }
            if (graph[i][graph[0].length - 1] == 1 && visited[i][graph[0].length - 1] == 0) {
                dfs(graph, visited, i, graph[0].length - 1, false);
            }
        }
        for (int j = 0; j < m; j++) {
            if (graph[0][j] == 1 && visited[0][j] == 0) {
                dfs(graph, visited, 0, j, false);
            }
            if (graph[graph.length - 1][j] == 1 && visited[graph.length - 1][j] == 0) {
                dfs(graph, visited, graph.length - 1, j, false);
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && visited[i][j] == 0) {
                    dfs(graph, visited, i, j, true);
                }
            }
        }

        // 打印结果
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (j == graph[i].length - 1) {
                    System.out.println(graph[i][j]);
                } else {
                    System.out.print(graph[i][j] + " ");
                }
            }
        }

    }

    public static void dfs(int[][] graph, int[][] visited, int x, int y, boolean change) {
        visited[x][y] = 1;
        if (change) {
            graph[x][y] = 0;
        }

        if (x - 1 >= 0 && graph[x - 1][y] == 1 && visited[x - 1][y] == 0) {
            dfs(graph, visited, x - 1, y, change);
        }
        if (x + 1 < graph.length && graph[x + 1][y] == 1 && visited[x + 1][y] == 0) {
            dfs(graph, visited, x + 1, y, change);
        }
        if (y - 1 >= 0 && graph[x][y - 1] == 1 && visited[x][y - 1] == 0) {
            dfs(graph, visited, x, y - 1, change);
        }
        if (y + 1 < graph[0].length && graph[x][y + 1] == 1 && visited[x][y + 1] == 0) {
            dfs(graph, visited, x, y + 1, change);
        }
    }
}
