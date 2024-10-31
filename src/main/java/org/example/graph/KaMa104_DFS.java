package org.example.graph;

import java.util.Scanner;

public class KaMa104_DFS {

    static int count = 0;
    static boolean changed = false;

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
                    count = 0;
                    dfs(graph, visited, i, j);
                    result = Math.max(result, count);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    int[][] visited2 = new int[n][m];
                    count = 0;
                    dfs(graph, visited2, i, j);
                    result = Math.max(result, count);
                }
            }
        }

        System.out.println(result);
    }

    public static void dfs(int[][] graph, int[][] visited, int x, int y) {
        visited[x][y] = 1;
        count++;

        if (x - 1 >= 0 && graph[x - 1][y] == 1 && visited[x - 1][y] == 0) {
            dfs(graph, visited, x - 1, y);
        }
        if (x + 1 < graph.length && graph[x + 1][y] == 1 && visited[x + 1][y] == 0) {
            dfs(graph, visited, x + 1, y);
        }
        if (y - 1 >= 0 && graph[x][y - 1] == 1 && visited[x][y - 1] == 0) {
            dfs(graph, visited, x, y - 1);
        }
        if (y + 1 < graph[0].length && graph[x][y + 1] == 1 && visited[x][y + 1] == 0) {
            dfs(graph, visited, x, y + 1);
        }
    }
}
