package org.example.graph;

import java.util.*;

/**
 * 可以发现 dijkstra的代码看上去 怎么和 prim算法这么像呢。
 * 其实代码大体不差，唯一区别在 三部曲中的 第三步： 更新minDist数组
 * <p>
 * 带有负权值的最短路问题，可以使用 Bellman-Ford 算法
 * <p>
 * dijkstra 算法可以同时求 起点到所有节点的最短路径
 * 权值不能为负数
 * <p>
 * dijkstra三部曲：（邻接表 + dijkstra堆优化版）
 * 第一步，选源点到哪个节点近且该节点未被访问过（使用小顶堆，直接选取堆顶元素，取完需要重新堆排序，保持小顶堆）
 * 第二步，该最近节点被标记访问过
 * 第三步，更新非访问节点到源点的距离（即更新minDist数组，更新后要堆排序，保持小顶堆）
 */
public class KaMa47_dijkstra_priorityQueue {
    // 选取距离起点最近且未被访问的节点
    // 对选取的最近的未被访问的节点做标记
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 构建邻接矩阵图
        ArrayList<List<Edge>> graph = new ArrayList<>(n + 1);
        // 初始容量：ArrayList 的容量是指它可以容纳的元素数量
        // 实际大小：是 ArrayList 中实际存储的元素个数。创建时，graph 实际上是空的（没有元素），因此它的初始大小为 0。
        for (int i = 0; i < n + 1; i++) {
            graph.add(i, new ArrayList<Edge>());
        }
        for (int i = 0; i < m; i++) {
            graph.get(scanner.nextInt()).add(new KaMa47_dijkstra_priorityQueue().new Edge(scanner.nextInt(), scanner.nextInt()));
        }

        int[] minDist = new int[n + 1]; // 记录每个节点到起点的最短距离
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[1] = 0;

        boolean[] visited = new boolean[n + 1]; // 标记节点是否已被访问过
        Arrays.fill(visited, false);

        // PriorityQueue<Pair> bq = new PriorityQueue<>((a, b) -> {
        //     return Integer.compare(a.distance, b.distance);
        // }); // 用优先权队列 实现 小顶堆；优先权队列存储 指向可到达且未被访问的节点的弧
        // 发现排序规则不能用lambda表达式，否则会超时，说明lambda表达式性能很差
        PriorityQueue<Pair> bq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.distance, o2.distance);
            }
        }); // 用优先权队列 实现 小顶堆；优先权队列存储 指向可到达且未被访问的节点的弧

        // 起始点到自身的距离为0
        bq.add(new KaMa47_dijkstra_priorityQueue().new Pair(1, 0));

        while (!bq.isEmpty()) {
            // 步骤一：获取当前指向距离起点最近 且 未遍历的节点的弧
            Pair poll = bq.poll();
            int cur = poll.dist;
            int distance = poll.distance;

            // 步骤二：对寻找到的节点做标记
            visited[cur] = true;

            // 步骤三：更新minDist数组的信息，遍历cur节点所有出来的弧
            for (Edge edge : graph.get(cur)) {
                if (!visited[edge.to] && minDist[cur] + edge.val < minDist[edge.to]) {
                    minDist[edge.to] = minDist[cur] + edge.val;
                    bq.add(new KaMa47_dijkstra_priorityQueue().new Pair(edge.to, minDist[edge.to]));
                }
            }
        }
        if (minDist[n] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minDist[n]);
        }
    }

    class Edge {
        int to;
        int val;

        public Edge(int to, int val) {
            this.to = to;
            this.val = val;
        }
    }

    class Pair {
        int dist;
        int distance;

        public Pair(int dist, int distance) {
            this.dist = dist;
            this.distance = distance;
        }
    }
}