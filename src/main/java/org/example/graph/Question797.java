package org.example.graph;

import java.util.ArrayList;
import java.util.List;

public class Question797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> path = new ArrayList<>();

        // 根据graph构建出邻接矩阵
        int[][] graphMatrix = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                graphMatrix[i][graph[i][j]] = 1;
            }
        }

        // 开始dfs
        path.add(0);
        dfs(graphMatrix, 0, graphMatrix.length - 1, result, path);

        return result;
    }

    public void dfs(int[][] graph, int x, int n, List<List<Integer>> result, List<Integer> path) {
        if (x == n) {
            result.add(new ArrayList<>(path));
        } else {
            for (int i = 0; i < graph[x].length; i++) {
                if (graph[x][i] == 1) {
                    path.add(i);
                    dfs(graph, i, graph.length - 1, result, path);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
