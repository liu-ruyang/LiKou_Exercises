package org.example.niuke_top101.linklist;

import java.util.ArrayList;
import java.util.List;

public class BM12 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList(ListNode head) {
        // write code here
        List<ListNode> record = new ArrayList<>();
        while (head != null) {
            record.add(head);
            ListNode p = head;
            head = head.next;
            p.next = null;
        }

        ListNode res = merge_sort(record, 0, record.size() - 1);
        return res;
    }

    public ListNode merge_sort(List<ListNode> record, int left, int right) {
        if (left == right) {
            return record.get(left);
        }
        int mid = (left + right) / 2;
        ListNode p1 = merge_sort(record, left, mid);
        ListNode p2 = merge_sort(record, mid + 1, right);
        ListNode res = merge(p1, p2);
        return res;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode p = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            } else {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
        }
        while (l1 != null) {
            p.next = l1;
            l1 = l1.next;
            p = p.next;
        }
        while (l2 != null) {
            p.next = l2;
            l2 = l2.next;
            p = p.next;
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
