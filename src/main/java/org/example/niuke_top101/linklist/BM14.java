package org.example.niuke_top101.linklist;

public class BM14 {
    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(7);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        new BM14().oddEvenList(node);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode oddEvenList(ListNode head) {
        // write code here
        ListNode second = head != null ? head.next : head;

        ListNode even = new ListNode(-1);
        ListNode odd = new ListNode(-1);
        ListNode p = head;
        int count = 1;
        while (p != null) {
            if (count % 2 == 0) {
                even.next = p;
                p = p.next;
                even = even.next;
            } else {
                odd.next = p;
                p = p.next;
                odd = odd.next;
            }
            count++;
        }

        odd.next = second;

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
