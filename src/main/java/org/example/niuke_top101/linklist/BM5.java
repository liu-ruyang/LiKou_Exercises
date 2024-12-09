package org.example.niuke_top101.linklist;

import java.util.ArrayList;

public class BM5 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param lists ListNode类ArrayList
     * @return ListNode类
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        // write code here
        return bineryMerge(lists, 0, lists.size() - 1);
    }

    public ListNode bineryMerge(ArrayList<ListNode> lists, int left, int right) {
        if (left == right) {
            return lists.get(left);
        }
        if (left + 1 == right) {
            return merge(lists.get(left), lists.get(right));
        }
        int mid = (left + right) / 2;
        ListNode leftList = bineryMerge(lists, left, mid);
        ListNode rightList = bineryMerge(lists, mid + 1, right);
        return merge(leftList, rightList);
    }

    public ListNode merge(ListNode pHead1, ListNode pHead2) {
        // write code here
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (pHead1 != null && pHead2 != null) {
            if (pHead1.val < pHead2.val) {
                p.next = pHead1;
                p = p.next;
                pHead1 = pHead1.next;
            } else {
                p.next = pHead2;
                p = p.next;
                pHead2 = pHead2.next;
            }
        }
        while (pHead1 != null) {
            p.next = pHead1;
            p = p.next;
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            p.next = pHead2;
            p = p.next;
            pHead2 = pHead2.next;
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
