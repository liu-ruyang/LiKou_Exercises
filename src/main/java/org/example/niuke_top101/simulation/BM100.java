package org.example.niuke_top101.simulation;

import java.util.HashMap;

/**
 * 哈希表+双向链表
 */
public class BM100 {
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public static void main(String[] args) {
        // write code here
        BM100 bm100 = new BM100();

        bm100.capacity = 2;
        bm100.head = new Node();
        bm100.tail = bm100.head;
        bm100.map = new HashMap();

        // bm100.set(1, 1);
        // bm100.set(2, 2);
        // bm100.get(1);
        // bm100.set(3, 3);
        // bm100.get(2);
        // bm100.set(4, 4);
        // bm100.get(1);
        // bm100.get(3);
        // bm100.get(4);

        bm100.set(1, 1);
        bm100.set(1, 2);
        bm100.get(1);
    }

    public int get(int key) {
        // write code here
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        if (node.next != null) {    // node不是tail所指节点
            node.next.pre = node.pre;
            node.pre.next = node.next;

            this.head.next.pre = node;
            node.next = this.head.next;
            this.head.next = node;
            node.pre = this.head;
        } else {     // node是tail所指节点
            if (this.head.next != this.tail) { // 双向链表中不只有一个节点
                this.tail = this.tail.pre;
                this.tail.next = null;

                this.head.next.pre = node;
                node.next = this.head.next;
                this.head.next = node;
                node.pre = this.head;
            }
            // else {
            //     node.next.pre = node.pre;
            //     node.pre.next = node.next;
            //
            //     this.head.next.pre = node;
            //     node.next = this.head.next;
            //     this.head.next = node;
            //     node.pre = this.head;
            // }
        }
        return node.val;
    }

    public void set(int key, int value) {
        // write code here
        if (map.containsKey(
                key)) { // 链表中已存在，修改元素值后处理逻辑同get方法
            Node node = map.get(key);
            node.val = value;

            if (node.next != null) {    // node不是tail所指节点
                node.next.pre = node.pre;
                node.pre.next = node.next;

                this.head.next.pre = node;
                node.next = this.head.next;
                this.head.next = node;
                node.pre = this.head;
            } else {     // node是tail所指节点
                if (this.head.next != this.tail) { // 双向链表中不只有一个节点
                    this.tail = this.tail.pre;
                    this.tail.next = null;

                    this.head.next.pre = node;
                    node.next = this.head.next;
                    this.head.next = node;
                    node.pre = this.head;
                }
            }
            return;
        }
        if (map.size() <
                this.capacity) {   // 链表中未存在，未达到最大容量，不需要删除节点
            Node node = new Node(key, value);
            map.put(key, node);
            if (this.head.next == null) {   // 向空链表中添加节点
                node.pre = this.head;
                this.head.next = node;
                this.tail = node;
            } else {    // 向非空链表中添加节点
                node.next = this.head.next;
                this.head.next.pre = node;
                node.pre = this.head;
                this.head.next = node;
            }
        } else {    // 链表中未存在，已达到最大容量，需要删除节点
            Node node = new Node(key, value);
            map.put(key, node);

            // 先添加节点
            node.next = this.head.next;
            this.head.next.pre = node;
            node.pre = this.head;
            this.head.next = node;
            // 再删除尾节点
            this.tail = this.tail.pre;
            this.tail.next = null;
        }
    }


    static class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node(int val, Node pre, Node next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }
}
