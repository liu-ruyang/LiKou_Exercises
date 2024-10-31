package org.example.graph;

import java.util.*;

public class KaMa110_BFS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String beginStr = scanner.next();
        String endStr = scanner.next();

        ArrayList<String> stringList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stringList.add(scanner.next());
        }

        int res = ladderLength(beginStr, endStr, stringList);

        System.out.println(res);
    }

    public static int ladderLength(String beginStr, String endStr, List<String> list) {
        HashSet<String> set = new HashSet<>(list);      // 用于快速判断，新合成的字符串是否存在
        LinkedList<String> queue = new LinkedList<>();  // 用于BFS
        HashMap<String, Integer> map = new HashMap<>(); // 用于：1.记录当前已访问过的字符串 2.到字符串所的距离
        queue.add(beginStr);
        map.put(beginStr, 1);
        int len = 0;

        while (!queue.isEmpty()) {
            String string = queue.removeFirst();
            len = map.get(string);
            // char[] chars = string.toCharArray();
            
            // 下面两层遍历，用于对当前字符串改造，遍历所有可能合成的新的字符串
            for (int i = 0; i < string.length(); i++) {
                char[] chars = string.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    // String s = chars.toString();
                    String s = String.valueOf(chars);

                    if (s.equals(endStr)) {
                        return len + 1;
                    }

                    if (set.contains(s) && !map.containsKey(s)) {
                        queue.add(s);
                        set.add(s);
                        map.put(s, len + 1);
                    }
                }
            }
        }
        return 0;
    }

    class StringNode {
        String string;
        StringNode next;

        public StringNode(String string) {
            this.string = string;
        }

        public StringNode(String string, StringNode next) {
            this.string = string;
            this.next = next;
        }
    }
}
