package org.example.hot100.graph;

import java.util.HashMap;

public class Question208 {
    class Trie {
        HashMap<Character, Trie> map;
        boolean isEnd;

        public Trie() {
            map = new HashMap<>();
//            for (char i = 'a'; i <= 'z'; i++) {
//                map.put(i, null);
//            }
            this.isEnd = false;
        }

        public void insert(String word) {
            char[] chars = word.toCharArray();
            Trie node = this;
            for (int i = 0; i < chars.length; i++) {
                if (!node.map.containsKey(chars[i])) {
                    node.map.put(chars[i], new Trie());
                }
                node = node.map.get(chars[i]);
                if (i == chars.length - 1) {
                    node.isEnd = true;
                }
            }
        }

        public boolean search(String word) {
            char[] chars = word.toCharArray();
            Trie node = this;
            for (int i = 0; i < chars.length; i++) {
                if (node.map.containsKey(chars[i])) {
                    node = node.map.get(chars[i]);
                } else {
                    return false;
                }
            }
            return node.isEnd;
        }

        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            Trie node = this;
            for (int i = 0; i < chars.length; i++) {
                if (node.map.containsKey(chars[i])) {
                    node = node.map.get(chars[i]);
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
