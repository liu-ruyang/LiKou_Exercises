package org.example.hot100.linked_list;

public class Question25 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new Question25().reverseKGroup(head, 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode pre = preHead;
        ListNode p = pre;
        while (p != null) {
            int count = 0;
            while (count < k && p != null) {
                p = p.next;
                count++;
            }
            if (p != null) {
                ListNode nextStart = p.next;
                ListNode nextPre = pre.next;
                ListNode list = reverseList(pre.next, p);
                pre.next = list;

                pre = nextPre;
                p = pre;
            }
        }
        return preHead.next;
    }

    public ListNode reverseList(ListNode left, ListNode right) {
        ListNode preHead = new ListNode();
        ListNode p = left;
        ListNode flag = right.next;
        while (p != flag) {
            ListNode temp = p;
            p = p.next;
            temp.next = preHead.next;
            preHead.next = temp;
        }
        left.next = p;
        return preHead.next;
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
