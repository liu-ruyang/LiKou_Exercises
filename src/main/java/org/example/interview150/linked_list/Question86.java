package org.example.interview150.linked_list;

public class Question86 {
    public static void main(String[] args) {
        Question86.ListNode node = new Question86().new ListNode(2);
        // node = new Question86().new ListNode(2, node);
        node = new Question86().new ListNode(5, node);
        node = new Question86().new ListNode(2, node);
        node = new Question86().new ListNode(3, node);
        node = new Question86().new ListNode(4, node);
        node = new Question86().new ListNode(1, node);
        new Question86().partition(node, 3);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode();
        ListNode p1 = l1;
        ListNode l2 = new ListNode();
        ListNode p2 = l2;
        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                p1 = head;
                head = head.next;
            } else {
                p2.next = head;
                p2 = head;
                head = head.next;
            }
        }
        p1.next = null;
        p2.next = null;
        if (l1.next != null) {
            p1.next = l2.next;
            return l1.next;
        } else return l2.next;


    }

    // public ListNode partition(ListNode head, int x) {
    //     ListNode res = new ListNode();
    //     res.next = head;
    //     ListNode slow = res;
    //     ListNode fastPre = res;
    //     ListNode fast = head;
    //     while (fast != null) {
    //         if (fast.val < x) {
    //             ListNode p = fast.next;
    //             fastPre.next = fast.next;
    //             fast.next = slow.next;
    //             slow.next = fast;
    //             slow = slow.next;
    //             fast = p;
    //         } else {
    //             fastPre = fastPre.next;
    //             fast = fast.next;
    //         }
    //     }
    //     return res.next;
    // }

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
