package org.example.niuke_top101.linklist;

public class BM2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        ListNode cur = head;
        ListNode pre = null;
        int index = 1;
        while (index < m) {
            pre = cur;
            cur = cur.next;
            index++;
        }
        ListNode first = pre;
        ListNode first_next = cur;
        ListNode next;
        while (index <= n) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            index++;
        }
        if (first == null) {
            first_next.next = cur;
            return pre;
        } else {
            first.next = pre;
            first_next.next = cur;
            return head;
        }
    }

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
