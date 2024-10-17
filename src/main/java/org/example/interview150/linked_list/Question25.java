package org.example.interview150.linked_list;

public class Question25 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        ListNode node = new Question25().new ListNode(5);
        node = new Question25().new ListNode(4, node);
        node = new Question25().new ListNode(3, node);
        node = new Question25().new ListNode(2, node);
        node = new Question25().new ListNode(1, node);
        new Question25().reverseKGroup(node, 3);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode();
        res.next = head;

        ListNode low = res; // low始终指向每一组的前一个node
        ListNode fast = head;   // fast始终指向每一组的第一个node
        int count = 1;

        while (fast != null) {
            if (count >= k) {
                // 开始反转：尾插法
                int time = 0;

                ListNode record = low.next;

                while (time < k - 1) {
                    ListNode p = low.next;
                    low.next = low.next.next;

                    p.next = fast.next;
                    fast.next = p;

                    // fast = p;
                    time++;
                }

                // low = fast;
                low = record;
                fast = record;
                // fast = fast.next;
                count = 0;
            }
            if (fast != null)
                fast = fast.next;
            count++;
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
