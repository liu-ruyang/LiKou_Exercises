package org.example.niuke_top101.linklist;

import java.util.HashMap;
import java.util.Map;

public class BM16 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        Map map = new HashMap<Integer, Integer>();
        ListNode p = head;
        while (p != null) {
            if (map.containsKey(p.val)) {
                map.put(p.val, (int) map.get(p.val) + 1);
            } else {
                map.put(p.val, 1);
            }
            p = p.next;
        }

        ListNode res = new ListNode(-1);
        p = res;
        ListNode q = head;
        while (q != null) {
            if ((int) map.get(q.val) > 1) q = q.next;
            else {
                p.next = q;
                p = p.next;
                q = q.next;
            }
        }
        p.next = null;
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
