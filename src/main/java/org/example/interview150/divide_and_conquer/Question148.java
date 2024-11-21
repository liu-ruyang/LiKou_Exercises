package org.example.interview150.divide_and_conquer;

public class Question148 {
    public static void main(String[] args) {
        // 4,2,1,3
        ListNode node = new Question148().new ListNode(-1);
        ListNode head = node;
        node.next = new Question148().new ListNode(5);
        node = node.next;
        node.next = new Question148().new ListNode(3);
        node = node.next;
        node.next = new Question148().new ListNode(4);
        node = node.next;
        node.next = new Question148().new ListNode(0);
        node = node.next;
        new Question148().sortList(head);
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = sort(head);
        return node;
    }

    // 传入的形参是第一个节点
    // 返回一个排序后的链表的第一个节点
    public ListNode sort(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        // 快慢双指针
        ListNode slow = node;
        ListNode fast = node;

        // 1.寻找中间节点
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2.一个链表断为两个链表，用于合并
        ListNode node2 = slow.next;
        slow.next = null;

        ListNode sorted1 = sort(node);
        ListNode sorted2 = sort(node2);

        // 合并
        ListNode p = new ListNode();
        ListNode res = p;
        while (sorted1 != null && sorted2 != null) {
            if (sorted1.val < sorted2.val) {
                p.next = sorted1;
                sorted1 = sorted1.next;
                p = p.next;
            } else {
                p.next = sorted2;
                sorted2 = sorted2.next;
                p = p.next;
            }
        }
        while (sorted1 != null) {
            p.next = sorted1;
            p = p.next;
            sorted1 = sorted1.next;
        }
        while (sorted2 != null) {
            p.next = sorted2;
            p = p.next;
            sorted2 = sorted2.next;
        }
        return res.next;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
