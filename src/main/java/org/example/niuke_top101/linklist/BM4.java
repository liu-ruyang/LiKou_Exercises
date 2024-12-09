package org.example.niuke_top101.linklist;

public class BM4 {
    public ListNode Merge(ListNode pHead1, ListNode pHead2) {
        // write code here
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (pHead1 != null && pHead2 != null) {
            if (pHead1.val < pHead2.val) {
                p.next = pHead1;
                p = p.next;
                pHead1 = pHead1.next;
            } else {
                p.next = pHead2;
                p = p.next;
                pHead2 = pHead2.next;
            }
        }
        while (pHead1 != null) {
            p.next = pHead1;
            p = p.next;
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            p.next = pHead2;
            p = p.next;
            pHead2 = pHead2.next;
        }
        return res.next;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
