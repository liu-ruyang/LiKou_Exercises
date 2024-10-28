package org.example.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KaMa98_matrix {

    static List<List<Integer>> result;
    static List<Integer> list;

    public static void main(String[] args) {

        result = new ArrayList<>();
        list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 邻接矩阵法
        int[][] matrix = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            matrix[scanner.nextInt()][scanner.nextInt()] = 1;
        }

        list.add(1);
        dfs(matrix, 1, n);

        if (result.size() == 0)
            System.out.println(-1);

        for (int i = 0; i < result.size(); i++) {
            List<Integer> integers = result.get(i);
            for (int j = 0; j < integers.size() - 1; j++) {
                System.out.print(integers.get(j) + " ");
            }
            if (i != result.size() - 1) {
                System.out.println(integers.get(integers.size() - 1));
            } else {
                System.out.print(integers.get(integers.size() - 1));
            }
        }
    }

    public static void dfs(int[][] matrix, int x, int n) {
        for (int i = x + 1; i <= n; i++) {
            if (i == n && matrix[x][i] == 1) {
                list.add(i);
                // result.add(list);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            } else if (matrix[x][i] == 1) {
                list.add(i);
                dfs(matrix, i, n);
                list.remove(list.size() - 1);
            }
        }
    }
}
