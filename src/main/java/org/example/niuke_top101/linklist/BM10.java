package org.example.niuke_top101.linklist;

public class BM10 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while ((p1 != null || p2 != null) && p1 != p2) {
            if (p1 == null) p1 = pHead2;
            else p1 = p1.next;
            if (p2 == null) p2 = pHead1;
            else p2 = p2.next;
        }

        return p1;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
