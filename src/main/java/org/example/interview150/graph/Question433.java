package org.example.interview150.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Question433 {

    public static void main(String[] args) {
        String[] a = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        new Question433().minMutation("AACCGGTT", "AAACGGTA", a);
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < bank.length; i++) {
            map.put(bank[i], i);
        }

        // BFS遍历
        LinkedList<String> queue = new LinkedList<>();
        queue.add(startGene);

        String[] chars = {"A", "C", "G", "T"};

        boolean[] visited = new boolean[bank.length];
        Arrays.fill(visited, false);
        int len = queue.size(); // 记录某指定替换次数的新的字符串生成数
        int res = 0;

        while (!queue.isEmpty()) {
            String s1 = queue.removeFirst();

            for (String ch : chars) {   // 遍历替换方式（只有4个可替换字符串，不影响最终时间复杂度）
                for (int j = 0; j < s1.length(); j++) {     // 遍历替换位置

                    String s2 = s1.substring(0, j) + ch + s1.substring(j + 1);
                    // 新合成的字符串在bank中，且之前没有合成过该字符串
                    if (map.containsKey(s2) && !visited[map.get(s2)]) {
                        queue.add(s2);
                        visited[map.get(s2)] = true;
                        if (s2.equals(endGene)) {
                            return res + 1; // 新生成的字符串对应需要的替换次数还没有更新，需要 res + 1
                        }
                    }
                }
            }

            len--;
            if (len == 0) { // 某指定替换次数生成的字符串都已经弹出，需要更新后面再弹出的字符串的生成次数
                res++;
                len = queue.size();
            }

        }
        return -1;
    }
    //
    // public int minMutation(String startGene, String endGene, String[] bank) {
    //     int[][] graph = new int[bank.length][bank.length];
    //     for (int[] ints : graph) {
    //         Arrays.fill(ints, Integer.MAX_VALUE);
    //     }
    //     HashMap<String, Integer> map = new HashMap<>();
    //     for (int i = 0; i < bank.length; i++) {
    //         map.put(bank[i], i);
    //     }
    //     String[] chars = {"A", "C", "G", "T"};
    //     // 构建图邻接矩阵
    //     for (int i = 0; i < bank.length; i++) {
    //         String s1 = bank[i];
    //         for (String ch : chars) {   // 遍历替换方式
    //
    //             for (int j = 0; j < s1.length(); j++) {     // 遍历替换位置
    //                 String s2 = s1.substring(0, j) + ch + s1.substring(j + 1);
    //                 if (map.containsKey(s2)) {
    //                     int k = map.get(s2);
    //                     graph[i][k] = 1;
    //                     graph[k][i] = 1;
    //                 }
    //             }
    //         }
    //     }
    // }
}
