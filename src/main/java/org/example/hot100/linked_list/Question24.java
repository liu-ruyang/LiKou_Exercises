package org.example.hot100.linked_list;

public class Question24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preHead = new ListNode();
        ListNode pre = preHead;
        pre.next = head;
        ListNode left = head, right = head.next;
        while (left != null && right != null) {
            left.next = right.next;
            right.next = pre.next;
            pre.next = right;
            ListNode temp = left;

            pre = left;
            left = left.next;
            if (left != null) {
                right = left.next;
            }
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
