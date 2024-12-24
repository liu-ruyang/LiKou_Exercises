package org.example.niu_top202;

public class NB2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        if (head == null || head.next == null || head.next.next == null && head.val != head.next.val) return head;
        ListNode pre = head;
        ListNode post = head.next;
        while (post != null) {
            while (post != null && pre.val == post.val) {
                post = post.next;
                pre.next = post;
            }
            pre = pre.next;
            if (post != null) {
                post = post.next;
            }
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
