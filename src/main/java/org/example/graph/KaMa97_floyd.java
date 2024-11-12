package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 我们分两种情况：
 * <p>
 * 节点i 到 节点j 的最短路径经过节点k
 * 节点i 到 节点j 的最短路径不经过节点k
 * 对于第一种情况，grid[i][j][k] = grid[i][k][k - 1] + grid[k][j][k - 1]
 * <p>
 * 思考，其中i，j，k三者顺序不重要，因为最终只需要看遍历的维度顺序。先遍历k，再遍历i，j
 * 这里的k不能单独指某个节点，k 一定要表示一个集合，即[1...k] ，表示节点1 到 节点k 一共k个节点的集合
 */
public class KaMa97_floyd {
    // 二维数组 形式
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] graph = new int[n + 1][n + 1];
        for (int[] ints : graph) {
            Arrays.fill(ints, Integer.MAX_VALUE);
            // Arrays.fill(ints, 10001);
        }

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int val = scanner.nextInt();
            graph[x][y] = val;
            graph[y][x] = val;
        }

        int q = scanner.nextInt();
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            lists.add(Arrays.asList(scanner.nextInt(), scanner.nextInt()));
        }

        // Floyd
        for (int k = 1; k <= n; k++) {

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                        graph[j][i] = graph[i][j];
                    }
                }
            }

        }

        for (List list : lists) {
            if (graph[(int) list.get(0)][(int) list.get(1)] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(graph[(int) list.get(0)][(int) list.get(1)]);
            }
        }

    }

    // 三维数组
    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //
    //     int n = scanner.nextInt();
    //     int m = scanner.nextInt();
    //
    //     int[][][] graph = new int[n + 1][n + 1][n + 1];
    //     for (int[][] ints : graph) {
    //         for (int[] anInt : ints) {
    //             Arrays.fill(anInt, Integer.MAX_VALUE);
    //         }
    //     }
    //     for (int i = 0; i < m; i++) {
    //         int x = scanner.nextInt();
    //         int y = scanner.nextInt();
    //         int val = scanner.nextInt();
    //         graph[0][x][y] = val;
    //         graph[0][y][x] = val;
    //     }
    //
    //     int q = scanner.nextInt();
    //     ArrayList<List<Integer>> lists = new ArrayList<>();
    //     for (int i = 0; i < q; i++) {
    //         lists.add(Arrays.asList(scanner.nextInt(), scanner.nextInt()));
    //     }
    //
    //     // Floyd
    //     for (int k = 1; k <= n; k++) {
    //         for (int i = 1; i <= n; i++) {
    //             for (int j = 1; j <= n; j++) {
    //                 // if (i != k && i != j && k != j) {
    //                 if (graph[k - 1][i][k] == Integer.MAX_VALUE || graph[k - 1][k][j] == Integer.MAX_VALUE) {
    //                     graph[k][i][j] = graph[k - 1][i][j];
    //                 } else {
    //                     graph[k][i][j] = Math.min(graph[k - 1][i][j], graph[k - 1][i][k] + graph[k - 1][k][j]);
    //                 }
    //                 graph[k][j][i] = graph[k][i][j];
    //                 // }
    //             }
    //         }
    //     }
    //
    //     for (List list : lists) {
    //         if (graph[n][(int) list.get(0)][(int) list.get(1)] == Integer.MAX_VALUE) {
    //             System.out.println(-1);
    //         } else {
    //             System.out.println(graph[n][(int) list.get(0)][(int) list.get(1)]);
    //         }
    //     }
    // }
}
