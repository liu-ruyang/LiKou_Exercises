package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Bellman_ford算法的核心思想：对所有边进行松弛n-1次操作（n为节点数量），从而求得目标最短路。
 * 普通Bellman_ford算法，要保证道路网络中不存在任何 负权回路
 * 解释：
 * 对所有边松弛一次，相当于计算 起点到达 与起点一条边相连的节点 的最短距离
 * 对所有边松弛两次 可以得到与起点 两条边相连的节点的最短距离
 * 对所有边松弛三次 可以得到与起点 三条边相连的节点的最短距离
 * <p>
 * 共有两个关键点：
 * ① “松弛”究竟是个啥？
 * ② 为什么要对所有边松弛 n - 1 次 （n为节点个数） ？
 */
public class KaMa94_bellman_ford {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Edge> edges = new ArrayList<>(m);

        for (int i = 0; i < m; i++) {
            edges.add(new Edge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }

        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[1] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (minDist[edge.start] < Integer.MAX_VALUE && minDist[edge.end] > minDist[edge.start] + edge.val) {
                    minDist[edge.end] = minDist[edge.start] + edge.val;
                }
            }
        }

        System.out.println(minDist[n] == Integer.MAX_VALUE ? "unconnected" : minDist[n]);
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
