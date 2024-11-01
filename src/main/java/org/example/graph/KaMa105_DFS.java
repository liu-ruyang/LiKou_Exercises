package org.example.graph;

import java.util.Scanner;

/**
 * 代码中可以看到dfs函数下面并没有回溯的操作。
 * 此时就要在思考本题的要求了，本题是需要判断 1节点 是否能到所有节点，那么我们就没有必要回溯去撤销操作了，只要遍历过的节点一律都标记上。
 * 那什么时候需要回溯操作呢？
 * 当我们需要搜索一条可行路径的时候，就需要回溯操作了，因为没有回溯，就没法“调头”
 */
public class KaMa105_DFS {
    static int count = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] graph = new int[n][k];
        int[] visited = new int[n];
        visited[0] = 1;

        for (int i = 0; i < k; i++) {
            graph[scanner.nextInt() - 1][scanner.nextInt() - 1] = 1;
        }

        for (int i = 0; i < graph[0].length; i++) {
            if (graph[0][i] == 1 && visited[i] == 0) {
                dfs(graph, visited, 0, i);
            }
        }
        System.out.println(count == n ? 1 : -1);
    }

    // x是当前节点
    public static void dfs(int[][] graph, int[] visited, int fromX, int x) {
        visited[x] = 1;
        count++;

        for (int i = 0; i < graph[0].length; i++) {
            if (graph[x][i] == 1 && visited[i] == 0) {
                dfs(graph, visited, x, i);
            }
        }
    }
}
