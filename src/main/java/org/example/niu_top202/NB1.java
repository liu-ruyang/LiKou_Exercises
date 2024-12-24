package org.example.niu_top202;

public class NB1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteNodes(ListNode head) {
        // write code here
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode node = head;
        while (node.next != null && node.next.next != null) {
            if (node.next.val > node.val && node.next.val > node.next.next.val) {
                node.next = node.next.next;
                // return head;
            }
            node = node.next;
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
