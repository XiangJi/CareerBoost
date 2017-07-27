package DSA.LinkedList.AddTwoNumbers;

import DSA.LinkedList.ListNode;

// 数学Carry进位技巧 ， 链表的基本操作
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode p = head;

        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;
            p.next = new ListNode(sum % 10);
            carry = sum / 10;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = carry + l1.val;
            p.next = new ListNode(sum % 10);
            carry = sum / 10;
            p = p.next;
            l1 = l1.next;
        }

        while (l2!= null) {
            int sum = carry + l2.val;
            p.next = new ListNode(sum % 10);
            carry = sum / 10;
            p = p.next;
            l2 = l2.next;
        }

        if (carry != 0) {
            p.next = new ListNode(carry);
        }

        return head.next;
    }
}