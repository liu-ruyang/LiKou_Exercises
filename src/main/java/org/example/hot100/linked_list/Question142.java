package org.example.hot100.linked_list;

public class Question142 {
    /*
    分解成两个问题：①是否有环 ②有环时，如何寻找环的入口位置

    分析有环的情况
    第一次相遇：使用快、慢双指针
        快指针每次走两步，慢指针每次走一步
        第一次相遇的时候，快指针比慢指针多走了n圈环的长度  =>（又因为快指针走的时慢指针的二倍）=> 慢指针走了n圈环的长度
    第二次相遇：使用两个慢指针，一个从head开始，一个从第一次结束时候的慢指针位置开始
        如果慢指针从head开始，那么走到环的入口的位置时，走的长度 = 非环长度 + n圈环的长度
        对比第一次相遇中的慢指针走的路程为n圈环的长度，那么第一次中的慢指针只需要再走 非环长度 ，就可以到达环的入口位置
        => 这两个慢指针只需要各自再走 非环长度 ，就可以同时到达环的入口位置
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow1 = head, fast = head.next;
        while (fast != slow1) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow1 = slow1.next;
        }   // 跳出循环只能是有环存在

        ListNode slow2 = head;
        slow1 = slow1.next;         // 在slow2初始化时候就走了一步，slow1要跟上
        while (slow2 != slow1) {
            slow2 = slow2.next;
            slow1 = slow1.next;
        }

        return slow1;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
