package org.example.graph;

import java.util.*;

/**
 * Bellman_ford 算法每次松弛 都是对所有边进行松弛;
 * 但真正有效的松弛，是基于已经计算过的节点在做的松弛。
 */
public class KaMa94_bellman_ford_spfa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Edge>[] edges = new List[n + 1];
        // Arrays.fill(edges, new ArrayList<Edge>());   // 这样会使所有的edges[i]指向同一个实例对象
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < m; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int val = scanner.nextInt();
            edges[start].add(new Edge(start, end, val));
        }

        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[1] = 0;

        // 优化队列
        LinkedList<Integer> queue = new LinkedList<>();

        // for (int i = 0; i < n - 1; i++) {
        queue.add(1);
        int[] visited = new int[n + 1];
        Arrays.fill(visited, 0);
        visited[1] = 1;

        /**
         * 这里可能有录友疑惑，while (!que.empty()) 队里里 会不会造成死循环？ 例如 图中有环，这样一直有元素加入到队列里？
         * 正权回路 就是有环，但环的总权值为正数。
         *
         * 在有环且只有正权回路的情况下，即使元素重复加入队列，最后，也会因为 所有边都松弛后，节点数值（minDist数组）不在发生变化了 而终止。
         */
        while (!queue.isEmpty()) {
            Integer node = queue.removeFirst();
            visited[node] = 0;
            for (Edge edge : edges[node]) {
                if (minDist[edge.end] > minDist[edge.start] + edge.val) {
                    minDist[edge.end] = minDist[edge.start] + edge.val;

                    if (visited[edge.end] == 0) {   // 不能写在外面，因为如果出现正权回路的情况时，放外面会导致队列一直存在元素；而放里面，可以因为没有minDist不需要更新，从而不会有新节点加入到队列中
                        queue.add(edge.end);
                        visited[edge.end] = 1;
                    }
                }
                // if (visited[edge.end] == 0) {
                //     queue.add(edge.end);
                //     visited[edge.end] = 1;
                // }
                //
            }
        }
        // }

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
