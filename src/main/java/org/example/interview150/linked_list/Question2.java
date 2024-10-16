package org.example.interview150.linked_list;

public class Question2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode pre = head;
        ListNode res;

        int surplus = 0;
        while (l1 != null && l2 != null) {
            int num = (l1.val + l2.val + surplus) % 10;
            res = new ListNode(num);
            pre.next = res;
            pre = res;

            surplus = (l1.val + l2.val + surplus) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int num = (l1.val + surplus) % 10;
            res = new ListNode(num);
            pre.next = res;
            pre = res;

            surplus = (l1.val + surplus) / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            int num = (l2.val + surplus) % 10;
            res = new ListNode(num);
            pre.next = res;
            pre = res;

            surplus = (l2.val + surplus) / 10;
            l2 = l2.next;
        }
        while (surplus != 0) {
            int num = surplus % 10;
            res = new ListNode(num);
            pre.next = res;
            pre = res;

            surplus = surplus / 10;
        }

        return head.next;
    }

    public class ListNode {
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

