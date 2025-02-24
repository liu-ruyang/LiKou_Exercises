package org.example.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// dfs模板
// void dfs(参数) {
//     if (终止条件) {
//         存放结果;
//         return;
//     }
//     for (选择:
//          本节点所连接的其他节点) {
//         处理节点;
//         dfs(图，选择的节点);   // 递归
//         回溯，撤销处理结果;
//     }
// }
public class KaMa98_matrix {

    static List<List<Integer>> result;
    static List<Integer> path;

    public static void main(String[] args) {

        result = new ArrayList<>();
        path = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 邻接矩阵法
        int[][] graph = new int[n + 1][n + 1];
        // 读取输入，构建邻接矩阵
        for (int i = 0; i < m; i++) {
            graph[scanner.nextInt()][scanner.nextInt()] = 1;
        }

        // 开始dfs
        path.add(1);
        dfs(graph, 1, n);

        // 考虑特殊结果
        if (result.size() == 0) {
            System.out.println(-1);
        }
        // 打印结果
        for (List<Integer> integers : result) {
            for (int i = 0; i < integers.size(); i++) {
                if (i == integers.size() - 1) {
                    System.out.println(integers.get(i));
                } else {
                    System.out.print(integers.get(i) + " ");
                }
            }
        }
    }

    public static void dfs(int[][] graph, int x, int n) {
        if (x == n) {
            result.add(new ArrayList<>(path));
        } else {
            for (int i = x + 1; i < graph[x].length; i++) {
                if (graph[x][i] == 1) {
                    path.add(i);
                    dfs(graph, i, n);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
