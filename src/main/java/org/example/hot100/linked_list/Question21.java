package org.example.hot100.linked_list;

public class Question21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode();
        ListNode p = preHead;
        ListNode node1 = list1;
        ListNode node2 = list2;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                p.next = node1;
                node1 = node1.next;
            } else {
                p.next = node2;
                node2 = node2.next;
            }
            p = p.next;
        }

        while (node1 != null) {
            p.next = node1;
            node1 = node1.next;
            p = p.next;
        }
        while (node2 != null) {
            p.next = node2;
            node2 = node2.next;
            p = p.next;
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
