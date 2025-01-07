package org.example.hot100.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Question207 {
    public static void main(String[] args) {
        int[][] a = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        new Question207().canFinish(5, a);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length <= 0) {
            return true;
        }
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();    // 键-值：课程编号-入度，记录入度不为0的节点
        for (int i = 0; i < prerequisites.length; i++) {
            if (inDegree.containsKey(prerequisites[i][1])) {
                inDegree.put(prerequisites[i][1], inDegree.get(prerequisites[i][1]) + 1);
            } else {
                inDegree.put(prerequisites[i][1], 1);
            }
            if (!map.containsKey(prerequisites[i][0])) {
                map.put(prerequisites[i][0], new ArrayList<>());
            }
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        LinkedList<Integer> queue = new LinkedList<>(); // 记录入度为0的节点
        for (int i = 0; i < numCourses; i++) {
            if (!inDegree.containsKey(i)) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            List<Integer> list = map.get(queue.pop());
            if (list != null) {
                for (Integer i : list) {    // i是出节点编号
                    inDegree.put(i, inDegree.get(i) - 1);
                    if (inDegree.get(i) == 0) {
                        inDegree.remove(i);
                        queue.add(i);
                    }
                }
            }
        }
        return inDegree.isEmpty();
    }
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        HashMap<Integer, Integer> inDegree = new HashMap<>();    // 键-值：课程编号-入度，记录入度不为0的节点
//        for (int i = 0; i < prerequisites.length; i++) {
//            if (inDegree.containsKey(prerequisites[i][1])) {
//                inDegree.put(prerequisites[i][1], inDegree.get(prerequisites[i][1]) + 1);
//            } else {
//                inDegree.put(prerequisites[i][1], 1);
//            }
//        }
//
////        LinkedList<Integer> queue = new LinkedList<>(); // 记录入度为0的节点
////        for (int i = 0; i < numCourses; i++) {
////            if (!map.containsKey(i)) {
////                queue.add(i);
////            }
////        }
//        HashMap<Integer, HashSet<Integer>> outDegree = new HashMap<>();
//        for (int i = 0; i < prerequisites.length; i++) {
//            if (!inDegree.containsKey(prerequisites[i][0])) {       // 记录入度为0的节点
//                if (!outDegree.containsKey(prerequisites[i][0])) {
//                    outDegree.put(prerequisites[i][0], new HashSet<>());
//                }
//                outDegree.get(prerequisites[i][0]).add(prerequisites[i][1]);
//            }
//        }
//
////        ArrayList<HashSet<Integer>> queue = (ArrayList<HashSet<Integer>>) outDegree.values().stream().toList();
//        List<HashSet<Integer>> queue = new ArrayList<>(outDegree.values());
//
//        while (!queue.isEmpty()) {
//            HashSet<Integer> set = queue.get(0);
//            for (Integer i : set) {
//                if (inDegree.containsKey(i)) {
//                    inDegree.put(prerequisites[i][1], inDegree.get(prerequisites[i][1]) - 1);
//                    if (inDegree.get(prerequisites[i][1]) == 0) {
//                        inDegree.remove(prerequisites[i][1]);
//                        queue.add(new HashSet<Integer>());
//                        queue.get(queue.size() - 1).add(prerequisites[i][1]);
//                    }
//                }
//            }
//            queue.remove(0);
//        }
//
//        return inDegree.isEmpty();
//    }
}
