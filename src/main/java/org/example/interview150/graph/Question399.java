package org.example.interview150.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Question399 {

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));

        new Question399().calcEquation(equations, values, queries);

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Integer> map = new HashMap<>(); // 字符串映射到图矩阵的下标
        int count = 0;
        for (List<String> equation : equations) {
            for (int i = 0; i < equation.size(); i++) {
                if (!map.containsKey(equation.get(i))) {
                    map.put(equation.get(i), count);
                    count++;
                }
            }
        }

        double[][] graph = new double[count][count];
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], 21);
        }

        for (int i = 0; i < equations.size(); i++) {
            graph[map.get(equations.get(i).get(0))][map.get(equations.get(i).get(1))] = values[i];
            graph[map.get(equations.get(i).get(1))][map.get(equations.get(i).get(0))] = 1 / values[i];
        }

        // Floyd
        for (int k = 0; k < count; k++) {
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < count; j++) {
                    if (graph[i][k] != 21 && graph[k][j] != 21) {
                        graph[i][j] = graph[i][k] * graph[k][j];
                        graph[j][i] = 1 / graph[i][j];
                    }
                }
            }
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            if (!map.containsKey(queries.get(i).get(0)) || !map.containsKey(queries.get(i).get(1)) || graph[map.get(queries.get(i).get(0))][map.get(queries.get(i).get(1))] == 21) {
                res[i] = -1;
            } else {
                res[i] = graph[map.get(queries.get(i).get(0))][map.get(queries.get(i).get(1))];
            }
        }
        return res;
    }
}
