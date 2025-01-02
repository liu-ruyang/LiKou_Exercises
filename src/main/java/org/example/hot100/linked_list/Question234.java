package org.example.hot100.linked_list;

public class Question234 {
    public static void main(String[] args) {
//        1,2,2,1
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(1);
        new Question234().isPalindrome(head);
    }

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }

        // 先反转一半链表，然后使用快慢指针比较节点
        ListNode preHead = new ListNode();
        preHead.next = head;
        p = head;
        for (int i = 0; i < len / 2; i++) {
            ListNode pre = p;
            p = p.next;
            if (pre != head) {
                pre.next = preHead.next;
                preHead.next = pre;
            }
        }
        head.next = p;

        // 如果节点数为奇数，还应当向后移一个节点
        if (len % 2 != 0) {
            p = p.next;
        }
        // 使用快慢双指针比较
        ListNode q = preHead.next;
        while (p != null) {
            if (q.val != p.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
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
