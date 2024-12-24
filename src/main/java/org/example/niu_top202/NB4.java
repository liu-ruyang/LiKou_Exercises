package org.example.niu_top202;

public class NB4 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = new ListNode(-1);
        pre.next = slow;
        ListNode res = pre;

        while (fast != null) {
            int count = k;
            while (fast != null && count > 1) {
                fast = fast.next;
                count--;
            }
            if (fast != null && count == 1) {
                // 从slow到fast进行反转
                ListNode p = slow.next;
                slow.next = fast.next;
                while (p != slow.next) {
                    ListNode tmp = p.next;
                    p.next = pre.next;
                    pre.next = p;
                    p = tmp;
                }
                pre = slow;
                slow = slow.next;
                fast = slow;

            }
        }

        return res.next;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
