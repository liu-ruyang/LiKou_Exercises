package org.example.hot100.linked_list;

public class Question206 {
    public ListNode reverseList(ListNode head) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        if (head == null || head.next == null) {
            return preHead.next;
        }
        ListNode p = head.next;
        head.next = null;
        while (p != null) {
            ListNode pre = p;
            p = p.next;
            pre.next = preHead.next;
            preHead.next = pre;
        }
        return preHead.next;
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
