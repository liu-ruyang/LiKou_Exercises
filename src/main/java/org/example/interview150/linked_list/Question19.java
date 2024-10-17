package org.example.interview150.linked_list;

public class Question19 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        Question19.ListNode node = new Question19().new ListNode(5);
        node = new Question19().new ListNode(4, node);
        node = new Question19().new ListNode(3, node);
        node = new Question19().new ListNode(2, node);
        node = new Question19().new ListNode(1, node);

        new Question19().removeNthFromEnd(node, 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode res = new ListNode();
        res.next = head;
        ListNode fast = head;
        int count = 1;
        while (count < n) {
            fast = fast.next;
            count++;
        }

        ListNode low = res;
        while (fast.next != null) {
            fast = fast.next;
            low = low.next;
        }

        if (low.next != null)
            low.next = low.next.next;

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
