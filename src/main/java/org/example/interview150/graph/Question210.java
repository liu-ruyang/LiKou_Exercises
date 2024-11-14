package org.example.interview150.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Question210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        // boolean[] visited = new boolean[numCourses];
        Arrays.fill(inDegree, 0);
        // Arrays.fill(visited, false);

        // 计算入度
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            // 1. 选择一个入度为0节点
            int cur = queue.poll();

            // 2. 添加到学习
            res.add(cur);
            // visited[cur] = true;

            // 3. 更新剩余节点入度信息
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == cur) {
                    inDegree[prerequisites[i][0]]--;
                    if (inDegree[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        if (res.size() != numCourses) {
            return new int[0];
        } else {
            return res.stream().mapToInt(Integer::intValue).toArray();
        }

    }
}
