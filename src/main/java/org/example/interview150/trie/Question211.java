package org.example.interview150.trie;

import java.util.HashMap;
import java.util.Set;

public class Question211 {

    public static void main(String[] args) {
        WordDictionary dictionary = new Question211().new WordDictionary();
        // dictionary.addWord("bad");
        // dictionary.addWord("dad");
        // dictionary.addWord("mad");
        // dictionary.search("pad");
        // dictionary.search("bad");
        // dictionary.search(".ad");
        // dictionary.search("b..");

        dictionary.addWord("at");
        dictionary.addWord("and");
        dictionary.addWord("an");
        dictionary.addWord("add");
        dictionary.search("a");
        dictionary.search(".at");
        dictionary.addWord("bat");
        dictionary.search(".at");
        dictionary.search("an.");
        dictionary.search("a.d.");
        dictionary.search("b.");
        dictionary.search("a.d");
        dictionary.search(".");
    }

    class WordDictionary {

        HashMap<Character, WordDictionary> children;
        boolean isEnd;
        int depth;

        public WordDictionary() {
            children = new HashMap<>();
            isEnd = false;
            depth = 0;
        }

        public void addWord(String word) {
            WordDictionary dictionary = this;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (dictionary.children.containsKey(c)) {
                    dictionary = dictionary.children.get(c);
                } else {
                    WordDictionary newDictionary = new WordDictionary();
                    newDictionary.depth = dictionary.depth + 1;
                    newDictionary.children = new HashMap<>();
                    dictionary.children.put(c, newDictionary);
                    dictionary = dictionary.children.get(c);
                }
                if (i == word.length() - 1) {
                    dictionary.isEnd = true;
                }
            }
        }

        public boolean search(String word) {
            WordDictionary dictionary = this; // 本轮可用字典

            for (int i = 0; i < word.length(); i++) {
                // 本轮待匹配字符
                char c = word.charAt(i);
                if (c == '.') {
                    boolean found = false;
                    Set<Character> set = dictionary.children.keySet();
                    for (Character character : set) {
                        // 用character匹配当前的'.'字符
                        WordDictionary newDictionary = dictionary.children.get(character); // 注意：更新dictionary为下一轮字典，'.'不同于字母，dictionary还需要指定为当前的dictionary，需要用新的变量指向下一轮的字典
                        if (i == word.length() - 1 && newDictionary.isEnd) {
                            return true;
                        }
                        found = dfs(word, i + 1, newDictionary);
                        if (found) {
                            return true;
                        }
                    }
                    return found;

                } else if (dictionary.children.containsKey(c)) { // 本轮字典dictionary.children中含有该字符c
                    dictionary = dictionary.children.get(c); // 更新dictionary为下一轮字典
                    if (i == word.length() - 1 && dictionary.isEnd) {
                        return dictionary.isEnd;
                    }

                } else {
                    return false;
                }

            }

            return false;
        }

        public boolean dfs(String word, int i, WordDictionary dictionary) {

            for (; i < word.length(); i++) {
                // 本轮待匹配字符
                char c = word.charAt(i);
                if (c == '.') { // 碰到'.'字符，那么后面的字符需要用dfs遍历判断
                    boolean found = false;
                    Set<Character> set = dictionary.children.keySet();
                    for (Character character : set) {
                        // 用character匹配当前的'.'字符
                        WordDictionary newDictionary = dictionary.children.get(character); // 更新dictionary为下一轮字典
                        if (i == word.length() - 1 && newDictionary.isEnd) {
                            return true;
                        }
                        found = dfs(word, i + 1, newDictionary);
                        // if (dictionary == null) {
                        // continue;
                        // }
                        if (found) {
                            return true;
                        }
                    }
                    return found;

                } else if (dictionary.children.containsKey(c)) { // 本轮字典dictionary.children中含有该字符c
                    dictionary = dictionary.children.get(c); // 更新dictionary为下一轮字典
                    if (i == word.length() - 1 && dictionary.isEnd) {
                        return dictionary.isEnd;
                    }

                } else {
                    return false;
                }

            }
            return false;

        }


        // public boolean search(String word) {
        //     WordDictionary dictionary = this;
        //
        //     for (int i = 0; i < word.length(); i++) {
        //         char c = word.charAt(i);    // 待匹配字符
        //         if (c == '.') {
        //
        //             Set<Character> characters = dictionary.children.keySet();
        //             // for (Character character : characters) {
        //             Character[] array = new Character[characters.size()];
        //             characters.toArray(array);
        //             for (int j = 0; j < array.length; j++) {
        //                 Character character = array[j];
        //                 dictionary = dictionary.children.get(character);
        //                 if (dictionary != null) {
        //                     boolean found = dfs(word, i + 1, dictionary);
        //                     if (found) {
        //                         return true;
        //                     }
        //                 }
        //                 if (j == array.length - 1) {
        //                     return false;
        //                 }
        //             }
        //
        //         } else if (dictionary.children.containsKey(c)) {
        //             dictionary = dictionary.children.get(c);
        //         } else {
        //             break;
        //         }
        //         if (i == word.length() - 1 && word.length() == dictionary.depth) {
        //             return dictionary.isEnd;
        //         }
        //
        //     }
        //     return false;
        // }

        //     public boolean dfs(String word, int i, WordDictionary dictionary) {
        //         for (; i < word.length(); i++) {
        //             char c = word.charAt(i);
        //             if (c == '.') {
        //
        //                 Set<Character> characters = dictionary.children.keySet();
        //                 // for (Character character : characters) {
        //                 Character[] array = new Character[characters.size()];
        //                 characters.toArray(array);
        //                 for (int j = 0; j < array.length; j++) {
        //                     Character character = array[j];
        //                     dictionary = dictionary.children.get(character);
        //                     if (dictionary != null) {
        //                         boolean found = dfs(word, i + 1, dictionary);
        //                         if (found) {
        //                             return true;
        //                         }
        //                     }
        //                     if (j == array.length - 1) {
        //                         return false;
        //                     }
        //                 }
        //
        //             } else if (dictionary.children.containsKey(c)) {
        //                 dictionary = dictionary.children.get(c);
        //             } else {
        //                 break;
        //             }
        //             if (i == word.length() - 1) {
        //                 return dictionary.isEnd;
        //             }
        //
        //         }
        //         return false;
        //     }
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */