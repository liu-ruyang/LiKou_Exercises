package org.example.niuke_top101.linklist;

import java.util.ArrayList;

public class BM13 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }

        int left = 0, right = list.size() - 1;
        while (left < right) {
            if (list.get(left).intValue() != list.get(right).intValue()) return false;
            left++;
            right--;
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
