package org.example.interview150.graph;

import java.util.Arrays;
import java.util.LinkedList;

public class Question207 {

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        new Question207().canFinish(5, prerequisites);
    }

    // 1. 选择入度为 0 的课程
    // 2. 加入学习课程
    // 3. 更新剩余课程节点入度
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Arrays.fill(inDegree, 0);

        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][1]]++;
        }


        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;

        int[] visited = new int[numCourses];
        Arrays.fill(visited, 0);

        while (!queue.isEmpty()) {
            // 1.选择入度为0的节点
            int cur = queue.removeFirst();
            // 2.学习该节点课程
            visited[cur] = 1;
            count++;
            // 3.更新入度信息
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][0] == cur && visited[prerequisites[i][1]] == 0) {
                    inDegree[prerequisites[i][1]]--;
                    if (inDegree[prerequisites[i][1]] == 0) {
                        queue.add(prerequisites[i][1]);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
