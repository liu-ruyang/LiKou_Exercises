package org.example.interview150.trie;

import java.util.Arrays;

public class Question208 {
    public static void main(String[] args) {
        Trie trie = new Question208().new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.search("app");
        trie.startsWith("app");
        trie.insert("app");
        trie.search("app");
    }

    class Trie {
        char ch;    // 可以不加，本体仅用于debug方便
        Trie[] children;
        boolean isEnd;

        public Trie() {
            children = new Trie[26];    // 表示26个英文字母
            Arrays.fill(children, null);
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Trie[] children = node.children;
                if (children[c - 'a'] != null) {
                    node = children[c - 'a'];
                } else {
                    children[c - 'a'] = new Trie();
                    node = children[c - 'a'];
                    node.ch = c;
                }
                if (i == word.length() - 1) {   // 需要放到外面，以防已经word之前是前缀，但还不算是单词
                    node.isEnd = true;
                }
            }
        }

        public boolean search(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Trie[] children = node.children;
                if (children[c - 'a'] != null) {
                    node = children[c - 'a'];
                    if (i == word.length() - 1) {
                        return node.isEnd;
                    }
                } else {
                    break;
                }
            }
            return false;
        }

        public boolean startsWith(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                Trie[] children = node.children;
                if (children[c - 'a'] != null) {
                    node = children[c - 'a'];
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
