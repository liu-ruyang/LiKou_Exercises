package org.example.interview150.linked_list;

public class Question61 {
    public static void main(String[] args) {
        ListNode node = new Question61().new ListNode(1);
        new Question61().rotateRight(node, 1);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;

        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        int n = k % len;

        if (n == 0) {
            return head;
        }

        ListNode fast = head;
        int count = 1;
        while (count < n) {
            fast = fast.next;
            count++;
        }

        ListNode pre = new ListNode();
        pre.next = head;
        while (fast.next != null) {
            fast = fast.next;
            pre = pre.next;
        }
        fast.next = head;
        head = pre.next;
        pre.next = null;
        return head;
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
