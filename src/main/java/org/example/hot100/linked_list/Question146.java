package org.example.hot100.linked_list;

import java.util.HashMap;

public class Question146 {
    public static void main(String[] args) {
//        LRUCache cache = new LRUCache(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);
//        cache.put(3, 3);
//        cache.get(2);
//        cache.put(4, 4);
//        cache.get(1);
//        cache.get(3);
//        cache.get(4);

        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.get(4);
        cache.get(3);
        cache.get(2);
        cache.get(1);
        cache.put(5, 5);
        cache.get(1);
        cache.get(2);
        cache.get(3);
        cache.get(4);
        cache.get(5);
    }

    static class LRUCache {
        int count;
        int capacity;
        HashMap<Integer, Node> map;
        Node first;
        Node last;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.count = 0;
            map = new HashMap<>();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            if (node == first) {    // 在第一个元素
                return node.val;
            }
            if (node == last) { // 在最后一个元素
                if (node.pre != null) {
                    node.pre.next = node.next;
                    last = node.pre;
                }
                if (node != first) {
                    node.next = first;
                    first.pre = node;
                    first = node;
                }
                return node.val;
            }
            // 是中间元素
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = first;
            first.pre = node;
            first = node;
            return node.val;
        }

        public void put(int key, int value) {
            Node node = new Node(value);
            node.key = key;
            if (map.containsKey(key)) { // key已经存在
                get(key);
                first.val = value;
            } else { // key还不存在
                count++;
                map.put(key, node);
                node.next = first;  // 按照先增加后删除的顺序会简单很多
                if (first != null) {
                    first.pre = node;
                }
                first = node;
                if (last == null) {
                    last = first;
                }
                if (count > capacity) {
                    map.remove(last.key);
                    last = last.pre;
                    last.next = null;
                    count--;
                }
            }
        }

        class Node {
            int key;
            int val;
            Node pre;
            Node next;

            public Node() {

            }

            public Node(int val) {
                this.val = val;
            }
        }
    }
}
