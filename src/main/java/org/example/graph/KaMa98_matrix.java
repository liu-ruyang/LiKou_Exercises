package org.example.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

//        for (int i = 0; i < result.size(); i++) {
//            List<Integer> integers = result.get(i);
//            for (int j = 0; j < integers.size() - 1; j++) {
//                System.out.print(integers.get(j) + " ");
//            }
//            if (i != result.size() - 1) {
//                System.out.println(integers.get(integers.size() - 1));
//            } else {
//                System.out.print(integers.get(integers.size() - 1));
//            }
//        }
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
//        for (int i = x + 1; i <= n; i++) {
//            if (i == n && graph[x][i] == 1) {
//                list.add(i);
//                // result.add(list);
//                result.add(new ArrayList<>(list));
//                list.remove(list.size() - 1);
//            } else if (graph[x][i] == 1) {
//                list.add(i);
//                dfs(graph, i, n);
//                list.remove(list.size() - 1);
//            }
//        }
    }
}
