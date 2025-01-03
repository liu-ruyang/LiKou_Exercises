package org.example.hot100.linked_list;

public class Question138 {
    public static void main(String[] args) {
        Node node = new Node(7);
        node.next = new Node(13);
        node.next.next = new Node(11);
        node.next.random = node;
        node.next.next.next = new Node(10);
        node.next.next.random = node.next.next.next.next;
        node.next.next.next.next = new Node(1);
        node.next.next.next.random = node.next.next;
        node.next.next.next.next.random = node;
        Node node1 = new Question138().copyRandomList(node);
        System.out.println();
    }

    // 迭代和节点拆分
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        // 将节点拆分为两个节点
        while (p != null) {
            Node node = new Node(p.val);
            node.next = p.next;
            p.next = node;
            p = node.next;
        }

        // 修正每个节点的新出现的子节点的 random 指针
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            if (p.next == null) break;
            p = p.next.next;
        }

        // 修正next指针
        p = head;
        Node q = head.next;
        Node res = head.next;
        while (q.next != null) {
            p.next = p.next.next;
            q.next = q.next.next;
            p = p.next;
            q = q.next;
        }
        p.next = null;

        // 修正next指针
//        p = head.next;
//        while (p != null) {
//            if (p.next == null) break;
//            p.next = p.next.next;
//            p = p.next;
//        }
//        return head.next;
        return res;
    }
//    public Node copyRandomList(Node head) {
//        HashMap<Node, Integer> map = new HashMap<>();
//        Node p = head;
//        int index = 0;
//        while (p != null) {
//            map.put(p, index);
//            index++;
//            p = p.next;
//        }
//
//        Node[] record = new Node[index];
//        Node preHead = new Node(-1);
//        Node q = preHead;
//        p = head;
//        index = 0;
//        while (p != null) {
//            q.next = new Node(p.val);
//            p = p.next;
//            q = q.next;
//            record[index++] = q;
//        }
//
//        p = preHead.next;   // p指向新链表
//        q = head;   // q指向旧链表
//        while (p != null) {
//            if (q.random != null) {
//                p.random = record[map.get(q.random)];
//            }
//            p = p.next;
//            q = q.next;
//        }
//        return preHead.next;
//    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node() {

        }
    }
}
