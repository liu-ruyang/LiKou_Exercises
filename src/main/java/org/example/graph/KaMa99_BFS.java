package org.example.graph;

import java.util.LinkedList;
import java.util.Scanner;

public class KaMa99_BFS {
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

        KaMa99_BFS ma99Bfs = new KaMa99_BFS();
        int res = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1 && visited[i][j] == 0) {
                    res++;
                    ma99Bfs.bfs(graph, visited, i, j);
                }
            }
        }

        System.out.println(res);
    }

    // 容易出现超时
    // 原因：标记节点访问过在从队列取出节点之后，这会导致很多节点重复添加进队列中
    // 解决：应当在节点添加进队列的时候，就标记该节点已经被访问
    public void bfs(int[][] graph, int[][] visited, int x, int y) {
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        visited[x][y] = 1;

        while (!queue.isEmpty()) {
            Pair pair = queue.removeFirst();
            // visited[pair.x][pair.y] = 1;

            if (pair.y + 1 < graph[0].length && graph[pair.x][pair.y + 1] == 1 && visited[pair.x][pair.y + 1] == 0) {
                queue.add(new Pair(pair.x, pair.y + 1));
                visited[pair.x][pair.y + 1] = 1;
            }
            if (pair.y - 1 >= 0 && graph[pair.x][pair.y - 1] == 1 && visited[pair.x][pair.y - 1] == 0) {
                queue.add(new Pair(pair.x, pair.y - 1));
                visited[pair.x][pair.y - 1] = 1;
            }
            if (pair.x + 1 < graph.length && graph[pair.x + 1][pair.y] == 1 && visited[pair.x + 1][pair.y] == 0) {
                queue.add(new Pair(pair.x + 1, pair.y));
                visited[pair.x + 1][pair.y] = 1;
            }
            if (pair.x - 1 >= 0 && graph[pair.x - 1][pair.y] == 1 && visited[pair.x - 1][pair.y] == 0) {
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
