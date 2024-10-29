package org.example.graph;

import java.util.Scanner;

/*
邻接矩阵、DFS
 */
public class KaMa99_DFS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int[][] graph = new int[n][m];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                graph[i][j] = scan.nextInt();
            }
        }
        int[][] visited = new int[n][m];

        int res = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1 && visited[i][j] == 0) {
                    res++;
                    dfs(graph, visited, i, j);
                }
            }
        }

        System.out.println(res);
    }

    public static void dfs(int[][] graph, int[][] visited, int x, int y) {
        visited[x][y] = 1;
        if (y < 0 || y >= graph[0].length || x < 0 || x >= graph.length) {
            return;
        }
        if (y - 1 >= 0 && graph[x][y - 1] == 1 && visited[x][y - 1] == 0) {
            dfs(graph, visited, x, y - 1);
        }
        if (x + 1 < graph.length && graph[x + 1][y] == 1 && visited[x + 1][y] == 0) {
            dfs(graph, visited, x + 1, y);
        }
        if (y + 1 < graph[0].length && graph[x][y + 1] == 1 && visited[x][y + 1] == 0) {
            dfs(graph, visited, x, y + 1);
        }
        if (x - 1 >= 0 && graph[x - 1][y] == 1 && visited[x - 1][y] == 0) {
            dfs(graph, visited, x - 1, y);
        }
    }
}
