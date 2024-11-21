package org.example.interview150.divide_and_conquer;

public class Question23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        return divideAndMerge(lists, 0, lists.length - 1);
    }

    public ListNode divideAndMerge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left == right - 1) {
            return merge(lists[left], lists[right]);
        }
        int mid = (left + right) / 2;
        ListNode list1 = divideAndMerge(lists, left, mid);
        ListNode list2 = divideAndMerge(lists, mid + 1, right);
        return merge(list1, list2);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode p = res;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                p.next = list1;
                p = p.next;
                list1 = list1.next;
            } else {
                p.next = list2;
                p = p.next;
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            p.next = list1;
            p = p.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            p.next = list2;
            p = p.next;
            list2 = list2.next;
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
