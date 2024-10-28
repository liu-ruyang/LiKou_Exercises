package org.example.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KaMa98_List {
    static List<List<Integer>> result;
    static List<Integer> path;

    public static void main(String[] args) {
        result = new ArrayList<>();
        path = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 邻接表法
        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i < m; i++) {
            
        }

    }

    public static void dfs() {

    }
}
