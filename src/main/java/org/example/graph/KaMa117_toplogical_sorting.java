package org.example.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 拓扑排序：给出一个有向图，把这个有向图转成线性的排序，就叫拓扑排序
 * 所以拓扑排序也是图论中判断有向无环图的常用方法
 * <p>
 * 拓扑排序的过程其实就两步：
 * ① 找到入度为0的节点，加入结果集
 * ② 将该节点从图中移除
 */
public class KaMa117_toplogical_sorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] inDegree = new int[n];

        // 邻接表表示图
        ArrayList<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // 构建邻接表；记录各节点入度
        for (int i = 0; i < m; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            List<Integer> list = graph.get(start);
            list.add(end);
            inDegree[end]++;
        }

        // 用队列暂存入度为0的节点
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 步骤一：将入度为0的节点，加入结果集
            Integer start = queue.removeFirst();
            res.add(start);

            // 将该节点从图中移除
            List<Integer> list = graph.get(start);
            for (int i = 0; i < list.size(); i++) {
                inDegree[list.get(i)]--;
                if (inDegree[list.get(i)] == 0) {
                    queue.add(list.get(i));
                }
            }
        }

        if (res.size() != n) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < res.size(); i++) {
                if (i == res.size() - 1) {
                    System.out.print(res.get(i));
                } else {
                    System.out.print(res.get(i) + " ");
                }
            }
        }
    }
}
