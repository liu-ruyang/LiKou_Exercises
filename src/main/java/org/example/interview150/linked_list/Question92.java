package org.example.interview150.linked_list;

public class Question92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode start = head;
        ListNode pre = res;

        int count = 1;
        while (count < left) {
            pre = start;
            start = start.next;
            count++;
        }
        
        ListNode p = start.next;
        while (count < right) {
            start.next = p.next;
            p.next = pre.next;
            pre.next = p;
            p = start.next;

            count++;
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
