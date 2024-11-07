package org.example.graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 可以发现 dijkstra的代码看上去 怎么和 prim算法这么像呢。
 * 其实代码大体不差，唯一区别在 三部曲中的 第三步： 更新minDist数组
 * <p>
 * 带有负权值的最短路问题，可以使用 Bellman-Ford 算法
 * <p>
 * dijkstra 算法可以同时求 起点到所有节点的最短路径
 * 权值不能为负数
 * <p>
 * dijkstra三部曲：
 * 第一步，选源点到哪个节点近且该节点未被访问过
 * 第二步，该最近节点被标记访问过
 * 第三步，更新非访问节点到源点的距离（即更新minDist数组）
 */
public class KaMa47_dijkstra {
    // 选取距离起点最近且未被访问的节点
    // 对选取的最近的未被访问的节点做标记
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 构建邻接矩阵图
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            graph[scanner.nextInt()][scanner.nextInt()] = scanner.nextInt();
        }

        int[] minDist = new int[n + 1]; // 记录每个节点到起点的最短距离
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[1] = 0;

        boolean[] visited = new boolean[n + 1];
        Arrays.fill(visited, false);

        for (int i = 0; i < n; i++) {   // 因为每次遍历只会有两种情况：①找到一个符合条件的节点；②没有符合的节点。所以最多只会找到n个节点

            int min = Integer.MAX_VALUE;
            int cur = 1;
            // 寻找距离起点最近的且未被访问过的节点
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && minDist[j] < min) {
                    min = minDist[j];
                    cur = j;
                }
            }
            // 对寻找到的节点做标记
            visited[cur] = true;
            // 更新minDist数组的信息
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && graph[cur][j] != Integer.MAX_VALUE && minDist[cur] + graph[cur][j] < minDist[j]) {   // 注意：要加上graph[cur][j] != Integer.MAX_VALUE，否则 minDist[cur] + graph[cur][j] 可能会出现内存溢出
                    minDist[j] = minDist[cur] + graph[cur][j];
                }
            }
        }
        if (minDist[n] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minDist[n]);
        }
    }
}
//public class KaMa47_dijkstra {
//    static int[] minDist;
//    static int[][] graph;
//    static int[] visited;
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//
//        graph = new int[n + 1][n + 1];
//        for (int i = 0; i < graph.length; i++) {
//            Arrays.fill(graph[i], Integer.MAX_VALUE);
//        }
//        for (int i = 0; i < m; i++) {
//            int x = scanner.nextInt();
//            int y = scanner.nextInt();
//            int v = scanner.nextInt();
//            graph[x][y] = v;
//        }
//
//        minDist = new int[n + 1]; // 节点到起点的最短距离
//        Arrays.fill(minDist, Integer.MAX_VALUE);
//        minDist[1] = 0;
//        visited = new int[n + 1];
//
//
//        // 步骤一：寻找距离起点最近且未被访问过的节点
//        int cur = findNear();
//
//
//        // 建议使用这种循环，相比下面的while循环，它可以算出所有节点到起点的最短距离。同时，如果不可达终点，后面多出来的次数，也只是重复可循环的情况，不会影响最终结果
//        // for (int i = 1; i <= n; i++) { // 遍历所有节点
//
//        while (cur != -1 && cur != n) { // 代表有下一个节点可选 且 该节点不是终点
//            // 步骤二：最近未被访问节点加入到
//            visited[cur] = 1;
//
//            // 步骤三：更新其他未被访问节点与起点的距离
//            for (int i = 1; i <= n; i++) {
//                if (visited[i] == 0 && graph[cur][i] < Integer.MAX_VALUE) {
//                    minDist[i] = Integer.min(minDist[i], minDist[cur] + graph[cur][i]);
//                }
//            }
//
//            // 步骤一：寻找距离起点最近且未被访问过的节点
//            cur = findNear();
//        }
//        if (cur == -1) {
//            System.out.println(-1);
//        } else {
//            System.out.println(minDist[cur]);
//        }
//    }
//
//    public static int findNear() {  // 选距离源点最近且未访问过的节点
//        int cur = -1;
//        int min = Integer.MAX_VALUE;
//        for (int i = 1; i <= graph.length - 1; i++) {
//            if (visited[i] == 0 && minDist[i] < min) {
//                cur = i;
//                min = minDist[i];
//            }
//        }
//        return cur;
//    }
//}
