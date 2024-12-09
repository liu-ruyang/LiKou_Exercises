package org.example.niuke_top101.linklist;

public class BM8 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        if (pHead == null || k == 0) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        int count = 1;
        while (count < k && fast.next != null) {
            fast = fast.next;
            count++;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            count++;
        }
        if (count < k) {
            return null;
        }
        return slow;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
