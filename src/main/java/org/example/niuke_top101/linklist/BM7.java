package org.example.niuke_top101.linklist;

import java.util.HashSet;
import java.util.Set;

public class BM7 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        Set set = new HashSet<ListNode>();
        ListNode p = pHead;
        while (p != null) {
            if (set.contains(p)) {
                return p;
            }
            set.add(p);
            p = p.next;
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
