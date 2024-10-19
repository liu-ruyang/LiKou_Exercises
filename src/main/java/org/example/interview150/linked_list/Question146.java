package org.example.interview150.linked_list;

import java.util.HashMap;

public class Question146 {

    public static void main(String[] args) {
//        LRUCache cache = new Question146().new LRUCache(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);
//        cache.put(3, 3);
//        cache.get(2);
//        cache.put(4, 4);
//        cache.get(1);
//        cache.get(3);
//        cache.get(4);

//        LRUCache cache = new Question146().new LRUCache(1);
//        cache.put(2, 1);
//        cache.get(2);
//        cache.put(3, 2);
//        cache.get(2);
//        cache.get(3);

        LRUCache cache = new Question146().new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        cache.get(1);
        cache.get(2);
    }

    class LRUCache {
        int capacity;
        int count;
        ListNode head, tail;
        HashMap<Integer, ListNode> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            count = 0;
            head = new ListNode();
            tail = head;
            map = new HashMap<>();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            ListNode node = map.get(key);
            if (node.next == null) {
                return node.val;
            }
            node.pre.next = node.next;
            node.next.pre = node.pre;

            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
            return node.val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                // map中有，只需更新val值
                ListNode node = map.get(key);
                node.val = value;
                if (node.next != null) {
                    node.next.pre = node.pre;
                    node.pre.next = node.next;
                    node.next = null;
                    node.pre = tail;
                    tail.next = node;
                    tail = node;
                }

            } else if (count >= capacity) {
                // map中已满，需要删一个，提供空间给新node
                ListNode node = head.next;
                if (head.next.next == null) {
                    map.remove(node.key);
                    node.val = value;
                    node.key = key;
                    map.put(key, node);
                    return;
                }
                head.next.next.pre = head;

                head.next = head.next.next;
                map.remove(node.key);

                node = new ListNode();
                node.val = value;
                node.key = key;
                node.pre = tail;
                tail.next = node;
                tail = node;
                map.put(key, node);
            } else {
                // map中没有，且有充足空间给新node
                ListNode node = new ListNode();
                node.val = value;
                node.key = key;
                node.pre = tail;
                tail.next = node;
                tail = node;
                map.put(key, node);
                count++;
            }
        }

        class ListNode {
            int key;
            int val;
            ListNode pre;
            ListNode next;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
