package org.example.hot100.linked_list;

public class Question23 {
    // 分治法
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists.length == 0) {
//            return null;
//        }
//        ListNode res = binerySort(lists, 0, lists.length - 1);
//        return res;
//    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode();
        ListNode p = preHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }

        while (list1 != null) {
            p.next = list1;
            list1 = list1.next;
            p = p.next;
        }
        while (list2 != null) {
            p.next = list2;
            list2 = list2.next;
            p = p.next;
        }
        return preHead.next;
    }

    public ListNode binerySort(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        ListNode list1 = binerySort(lists, left, mid);
        ListNode list2 = binerySort(lists, mid + 1, right);
        ListNode mergeList = merge(list1, list2);
        return mergeList;
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
