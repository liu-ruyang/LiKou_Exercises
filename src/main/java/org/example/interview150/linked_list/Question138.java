package org.example.interview150.linked_list;

import java.util.HashMap;

public class Question138 {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        Node res = new Node(-1);
        Node pointer = res;

        while (head != null) {
            if (!map.containsKey(head)) {
                // 当前head指针指向节点未遍历过
                Node node = new Node(head.val);
                pointer.next = node;

                map.put(head, node);

                if (head.random != null && !map.containsKey(head.random)) {
                    // 当前head指针指向节点的random未遍历过
                    Node random = new Node(head.random.val);
                    node.random = random;

                    map.put(head.random, random);
                } else if (head.random != null) {
                    // 当前head指针指向节点的random遍历过
                    node.random = map.get(head.random);
                }


            } else {
                // 当前head指针指向节点遍历过
                Node node = map.get(head);
                pointer.next = node;

                if (head.random != null && !map.containsKey(head.random)) {
                    // 当前head指针指向节点的random未遍历过
                    Node random = new Node(head.random.val);
                    node.random = random;

                    map.put(head.random, random);
                } else if (head.random != null) {
                    // 当前head指针指向节点的random遍历过
                    node.random = map.get(head.random);
                }
            }

            pointer = pointer.next;
            head = head.next;
        }

        return res.next;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
