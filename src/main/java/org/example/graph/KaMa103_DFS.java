package org.example.graph;

import java.util.Scanner;

public class KaMa103_DFS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        int[][] visited1 = new int[n][m];
        int[][] visited2 = new int[n][m];

        for (int i = 0; i < n; i++) {
            dfs(graph, visited1, i, 0);
            dfs(graph, visited2, i, graph[0].length - 1);
        }
        for (int j = 0; j < m; j++) {
            dfs(graph, visited1, 0, j);
            dfs(graph, visited2, graph.length - 1, j);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited1[i][j] == 1 && visited2[i][j] == 1) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }

    public static void dfs(int[][] graph, int[][] visited, int x, int y) {
        visited[x][y] = 1;
        if (x + 1 < graph.length && graph[x + 1][y] >= graph[x][y] && visited[x + 1][y] == 0) {
            dfs(graph, visited, x + 1, y);
        }
        if (x - 1 >= 0 && graph[x - 1][y] >= graph[x][y] && visited[x - 1][y] == 0) {
            dfs(graph, visited, x - 1, y);
        }
        if (y + 1 < graph[0].length && graph[x][y + 1] >= graph[x][y] && visited[x][y + 1] == 0) {
            dfs(graph, visited, x, y + 1);
        }
        if (y - 1 >= 0 && graph[x][y - 1] >= graph[x][y] && visited[x][y - 1] == 0) {
            dfs(graph, visited, x, y - 1);
        }
    }
}
