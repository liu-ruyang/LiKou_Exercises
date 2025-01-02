package org.example.hot100.linked_list;

public class Question160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while (p != q) {
            if (p == null) p = headA;
            else p = p.next;
            if (q == null) q = headB;
            else q = q.next;
        }
        return q;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
