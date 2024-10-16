package org.example.interview150.linked_list;

public class Question141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode low = head;
        while (fast != null && low != null) {
            if (fast == low) {
                return true;
            }
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
            low = low.next;
        }
        return false;
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


