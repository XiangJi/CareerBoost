package DSA.LinkedList.SwapNodesinPairs;

import DSA.LinkedList.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
                return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            // draw diagram prev, c, temp, t cn , tn, pn 这段就和range reverse一样
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
            // move by two steps
            prev = cur;
            cur = cur.next;
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