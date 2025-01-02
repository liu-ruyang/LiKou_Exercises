package org.example.hot100.linked_list;

public class Question19 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        new Question19().removeNthFromEnd(node, 1);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode right = head;
        for (int i = 0; i < n - 1; i++) {
            right = right.next;
        }

        ListNode preHead = new ListNode();
        ListNode pre = preHead;
        pre.next = head;
        ListNode left = head;
        right = right.next;

        while (right != null) {
            pre = pre.next;
            left = left.next;
            right = right.next;
        }

        pre.next = pre.next.next;
        return preHead.next;
    }

    static class ListNode {
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
