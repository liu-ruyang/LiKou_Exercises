package org.example.interview150.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Question127 {
    public static void main(String[] args) {
        new Question127().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> queue = new LinkedList<>();
        queue.add(beginWord);

        boolean[] visited = new boolean[wordList.size()];
        Arrays.fill(visited, false);

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            map.put(wordList.get(i), i);
        }

        int res = 1;
        int len = 1;
        while (!queue.isEmpty()) {
            String s = queue.removeFirst();
            len--;
            

            for (int i = 0; i < s.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    String s2 = s.substring(0, i) + c + s.substring(i + 1);
                    if (map.containsKey(s2) && visited[map.get(s2)] == false) {
                        queue.add(s2);
                        visited[map.get(s2)] = true;
                        if (s2.equals(endWord)) {
                            res++;
                            return res;
                        }

                    }
                }

            }

            if (len == 0) {
                res++;
                len = queue.size();
            }
        }

        return 0;
    }
}
