package org.example.interview150.linked_list;

public class Question21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode head = res;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                res.next = list1;
                res = res.next;
                list1 = list1.next;
            } else {
                res.next = list2;
                res = res.next;
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            // if (list1.val < list2.val) {
            res.next = list1;
            res = res.next;
            list1 = list1.next;
            // } else {
            //     res.next = list2;
            //     res = res.next;
            //     list2 = list2.next;
            // }
        }
        while (list2 != null) {
            // if (list1.val < list2.val) {
            //     res.next = list1;
            //     res = res.next;
            //     list1 = list1.next;
            // } else {
            res.next = list2;
            res = res.next;
            list2 = list2.next;
            // }
        }


        return head.next;
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
