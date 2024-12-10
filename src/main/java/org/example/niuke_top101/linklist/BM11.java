package org.example.niuke_top101.linklist;

import java.util.LinkedList;

public class BM11 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        LinkedList<Integer> stask1 = new LinkedList<>();
        LinkedList<Integer> stask2 = new LinkedList<>();

        while (head1 != null) {
            stask1.push(head1.val);
            head1 = head1.next;
        }
        while (head2 != null) {
            stask2.push(head2.val);
            head2 = head2.next;
        }

        int tmp = 0;
        ListNode post = null;
        while (!stask1.isEmpty() && !stask2.isEmpty()) {
            int num1 = stask1.pop();
            int num2 = stask2.pop();

            ListNode cur = new ListNode((num1 + num2 + tmp) % 10);
            tmp = (num1 + num2 + tmp) / 10;
            cur.next = post;
            post = cur;
        }
        while (!stask1.isEmpty()) {
            int num1 = stask1.pop();

            ListNode cur = new ListNode((num1 + tmp) % 10);
            tmp = (num1 + tmp) / 10;
            cur.next = post;
            post = cur;
        }
        while (!stask2.isEmpty()) {
            int num2 = stask2.pop();

            ListNode cur = new ListNode((num2 + tmp) % 10);
            tmp = (num2 + tmp) / 10;
            cur.next = post;
            post = cur;
        }

        if (tmp != 0) {
            ListNode cur = new ListNode(tmp % 10);
            cur.next = post;
            post = cur;
        }
        return post;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
