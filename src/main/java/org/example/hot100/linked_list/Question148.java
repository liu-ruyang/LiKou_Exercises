package org.example.hot100.linked_list;

public class Question148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        ListNode res = binerySort(head, p);
        return res;
    }

    // 分治法合并（二分法）
    public ListNode binerySort(ListNode left, ListNode right) {
        if (left == right) {
            return left;
        }

        ListNode midNode = getMidNode(left);
        ListNode rightStart = midNode.next;
        midNode.next = null;
        ListNode leftStart = binerySort(left, midNode);
        rightStart = binerySort(rightStart, right);

        ListNode mergeList = merge(leftStart, rightStart);

        return mergeList;
    }

    // 合并左右链表
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

    // 寻找中间节点
    public ListNode getMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != null) {
            slow = slow.next;
        }
        return slow;
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
