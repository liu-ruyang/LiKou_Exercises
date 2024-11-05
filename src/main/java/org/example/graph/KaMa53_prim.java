package org.example.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * prim三部曲：
 * 第一步，选距离生成树最近节点
 * 第二步，最近节点加入生成树
 * 第三步，更新非生成树节点到生成树的距离（即更新minDist数组）
 * <p>
 * minDist数组 是prim算法的灵魂，它帮助 prim算法完成最重要的一步，就是如何找到 距离最小生成树最近的点。
 */
public class KaMa53_prim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int e = scanner.nextInt();

        int[][] graph = new int[v + 1][v + 1];
        for (int i = 0; i < graph.length; i++) {    // 图矩阵要先初始化，再赋值
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < e; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int k = scanner.nextInt();
            graph[x][y] = k;
            graph[y][x] = k;
        }

        int[] minDist = new int[v + 1]; // 记录各个节点距离最小生成树的距离，实时更新
        for (int i = 0; i < minDist.length; i++) {
            minDist[i] = Integer.MAX_VALUE;
        }
        minDist[1] = Integer.MAX_VALUE - 1;    // 控制第一个节点被选中

        HashSet<Integer> set = new HashSet<>(); // 记录节点是否加入到生成树中

        for (int i = 1; i <= v; i++) {

            // 步骤一：选择距离最短的节点
            int min = Integer.MAX_VALUE;
            int cur = -1;   // 距离生成树距离最小的节点
            for (int j = 1; j <= v; j++) {
                if (!set.contains(j) && minDist[j] < min) {
                    min = minDist[j];
                    cur = j;
                }
            }

            // 步骤二：节点加入到最小生成树
            set.add(cur);

            // 步骤三：更新剩余节点的信息
            for (int j = 1; j <= v; j++) {
                if (!set.contains(j) && graph[cur][j] < minDist[j]) {
                    minDist[j] = graph[cur][j];
                }
            }
        }

        int sum = 0;
        for (int i = 2; i <= v; i++) {
            sum += minDist[i];
        }
        System.out.println(sum);
    }
}
