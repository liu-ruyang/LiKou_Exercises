package org.example.interview150.linked_list;

import java.util.HashSet;

public class Question82 {

    public static void main(String[] args) {
        ListNode node = new Question82().new ListNode(5);
        node = new Question82().new ListNode(5, node);
        // node = new Question82().new ListNode(4, node);
        // node = new Question82().new ListNode(4, node);
        // node = new Question82().new ListNode(3, node);
        // node = new Question82().new ListNode(3, node);
        // node = new Question82().new ListNode(2, node);
        // node = new Question82().new ListNode(1, node);
        new Question82().deleteDuplicates(node);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode();
        res.next = head;

        HashSet<Integer> set = new HashSet<>();
        ListNode slow = res;
        ListNode fast = head;

        while (fast != null) {
            // if (fast.next != null) {
            if (fast.next != null && fast.val == fast.next.val) {
                int val = fast.val;
                while (fast.next != null && fast.next.val == val) {
                    fast = fast.next;
                }
                fast = fast.next;
                if (fast == null) {
                    slow.next = fast;
                }
            } else {
                slow.next = fast;
                slow = fast;
                fast = fast.next;
            }
            // }
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
