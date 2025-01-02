package org.example.hot100.linked_list;

public class Question2 {
    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next = new ListNode(7);
//        node.next.next = new ListNode(3);
//        new Question2().reverse(node);
        ListNode node2 = new ListNode(9);
        node2.next = new ListNode(2);
//        node2.next.next = new ListNode(4);
//        new Question2().reverse(node);
        new Question2().addTwoNumbers(node, node2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode list1 = reverse(l1);
//        ListNode list2 = reverse(l2);
        ListNode list1 = l1;
        ListNode list2 = l2;

        int temp = 0;

        ListNode preHead = new ListNode();
        ListNode p = preHead;
        while (list1 != null && list2 != null) {
            p.next = new ListNode((list1.val + list2.val + temp) % 10);
            temp = (list1.val + list2.val + temp) / 10;
            p = p.next;
            list1 = list1.next;
            list2 = list2.next;
        }
        while (list1 != null) {
            p.next = new ListNode((list1.val + temp) % 10);
            temp = (list1.val + temp) / 10;
            p = p.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            p.next = new ListNode((list2.val + temp) % 10);
            temp = (list2.val + temp) / 10;
            p = p.next;
            list2 = list2.next;
        }

        if (temp > 0) {
            p.next = new ListNode(temp % 10);
        }

//        return reverse(preHead.next);
        return preHead.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode preHead = new ListNode();
        ListNode p = head;
        while (p != null) {
            ListNode temp = p;
            p = p.next;
            temp.next = preHead.next;
            preHead.next = temp;
        }
        return preHead.next;
    }

    static class ListNode {
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
