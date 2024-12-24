package org.example.niu_top202;

public class NB3 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode moveNthToEnd(ListNode head, int n) {
        // write code here
        ListNode res = head;
        ListNode fast = head;
        while (n > 1) {
            fast = fast.next;
            n--;
        }
        if (fast == head) return head;
        ListNode slow = head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            pre = pre.next;
        }
        if (slow == head) res = head.next;
        pre.next = slow.next;
        slow.next = fast.next;
        fast.next = slow;
        return res;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
