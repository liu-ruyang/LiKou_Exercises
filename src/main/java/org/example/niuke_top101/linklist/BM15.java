package org.example.niuke_top101.linklist;

public class BM15 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        if (head == null) return head;
        ListNode cur = head;
        ListNode next = head.next;

        while (next != null) {
            if (next.val == cur.val) next = next.next;
            else {
                cur.next = next;
                next = next.next;
                cur = cur.next;
            }
        }
        cur.next = null;
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
