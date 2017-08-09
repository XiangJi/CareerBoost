package DSA.LinkedList.SwapNodesinPairs;

import DSA.LinkedList.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
                return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode previous = dummy;



        while (previous != null && previous.next != null && previous.next.next != null) {
                ListNode p1 = previous.next;
                ListNode p2 = previous.next.next;
                // start swap, 先头尾,后中间
                previous.next = p2;
                p1.next = p2.next;

                p2.next = p1;

                // move previous
                previous = previous.next.next;
        }
        return dummy.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
                return head;
        }

        ListNode tmp = head.next;
        tmp.next = swapPairs(tmp.next);

        head.next = tmp.next;
        tmp.next = head;

        return tmp;
    }
}