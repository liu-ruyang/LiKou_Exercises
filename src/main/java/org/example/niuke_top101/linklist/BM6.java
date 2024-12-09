package org.example.niuke_top101.linklist;

public class BM6 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast != slow && fast.next != null &&
                fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow == fast;
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
