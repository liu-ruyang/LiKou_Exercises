package org.example.graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * kruscal的思路：
 * <p>
 * 步骤一：边的权值排序，因为要优先选最小的边加入到生成树里
 * 步骤二；遍历排序后的边：（这里可以使用并查集）
 * ① 如果边首尾的两个节点在同一个集合，说明如果连上这条边图中会出现环
 * ② 如果边首尾的两个节点不在同一个集合，加入到最小生成树，并把两个节点加入同一个集合
 */
public class KaMa53_kruscal {
    public static int[] father;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int v = scanner.nextInt();
        int e = scanner.nextInt();

        Edge[] edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            edges[i] = new KaMa53_kruscal().new Edge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        Arrays.sort(edges, (a, b) -> {
            return a.val - b.val;
        });

        // int[] visited = new int[v + 1];
        father = new int[v + 1];
        init();

        int sum = 0;
        for (int i = 0; i < v - 1; i++) {   // 寻找v-1条边即可
            for (int j = 0; j < edges.length; j++) {
                if (!isSame(edges[j].node1, edges[j].node2)) {
                    join(edges[j].node1, edges[j].node2);
                    sum += edges[j].val;
                    break;
                }
            }
        }

        System.out.println(sum);
    }

    public static void init() {
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

    public static int find(int u) {
        if (u == father[u]) {
            return u;
        }
        return father[u] = find(father[u]);
    }

    public static boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    public static void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        father[u] = v;
    }

    class Edge {
        int node1;
        int node2;
        int val;

        public Edge(int node1, int node2, int val) {
            this.node1 = node1;
            this.node2 = node2;
            this.val = val;
        }
    }
}
