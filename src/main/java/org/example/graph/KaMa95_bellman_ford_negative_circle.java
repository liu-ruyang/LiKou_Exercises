package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 三种情况：
 * ① 如果没有发现负权回路，则输出一个整数，表示从城市 1 到城市 n 的最低运输成本（包括政府补贴）。
 * ② 如果该整数是负数，则表示实现了盈利。如果发现了负权回路的存在，则输出 "circle"。
 * ③ 如果从城市 1 无法到达城市 n，则输出 "unconnected"。
 * <p>
 * 有负权回路的情况下，一直都会有更短的最短路，所以 松弛 第n次，minDist数组 也会发生改变
 */
public class KaMa95_bellman_ford_negative_circle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<KaMa94_bellman_ford.Edge> edges = new ArrayList<>(m);

        for (int i = 0; i < m; i++) {
            edges.add(new KaMa94_bellman_ford.Edge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }

        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[1] = 0;

        boolean circle = false;

        for (int i = 0; i < n; i++) {
            for (KaMa94_bellman_ford.Edge edge : edges) {
                if (i < n - 1 && minDist[edge.start] < Integer.MAX_VALUE && minDist[edge.end] > minDist[edge.start] + edge.val) {
                    minDist[edge.end] = minDist[edge.start] + edge.val;
                } else if (minDist[edge.start] < Integer.MAX_VALUE && minDist[edge.end] > minDist[edge.start] + edge.val) {
                    // 在松弛了第n次时，如果还有要更新的更短路径值，说明有负权回路
                    circle = true;
                }
            }
        }

        System.out.println(circle ? "circle" : minDist[n] == Integer.MAX_VALUE ? "unconnected" : minDist[n]);
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
