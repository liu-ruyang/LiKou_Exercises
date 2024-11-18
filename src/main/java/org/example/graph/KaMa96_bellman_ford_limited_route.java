package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 最多经过 k 个城市， 那么是 k + 1条边相连的节点
 * 所以本题就是求：起点最多经过k + 1 条边到达终点的最短距离。
 * 那么对所有边松弛 k + 1次，就是求 起点到达 与起点k + 1条边相连的节点的 最短距离
 */
public class KaMa96_bellman_ford_limited_route {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Edge> edges = new ArrayList<>(m);

        for (int i = 0; i < m; i++) {
            edges.add(new Edge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }

        int src = scanner.nextInt();
        int dst = scanner.nextInt();
        int k = scanner.nextInt();

        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[src] = 0;

        for (int i = 0; i < k + 1; i++) {
            for (Edge edge : edges) {
                if (minDist[edge.start] < Integer.MAX_VALUE && minDist[edge.end] > minDist[edge.start] + edge.val) {
                    minDist[edge.end] = minDist[edge.start] + edge.val;
                }
            }
        }

        System.out.println(minDist[dst] == Integer.MAX_VALUE ? "unreachable" : minDist[n]);
    }

    static class Edge {
        int start;
        int end;
        int val;

        public Edge(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }
}
