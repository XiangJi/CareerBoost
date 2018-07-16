package DSA.LinkedList.ReverseLinkedListII;

import DSA.LinkedList.ListNode;

/*
 * range reverse
 * 
 * sing 4 pointers: dummy, pre, tmp, cur
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        // use pointers
        ListNode prev = dummy;
        ListNode cur = dummy.next;
        
        for (int i = 1; i < m; i++) {
            cur = cur.next;
            prev = prev.next;
        }
        
        /*
         * 1 2 3 4 5
         * p c t
         * 2 -> 4
         * 3 -> 2
         * 1 -> 3
         * First swap: 1 3 2 4 5 
         * Second swap 1 4 3 2 5
         * 这个操作每次把cur的下一个放到最前面去
         * 
         * 两两互换
         * t, cn, tn,pn
         */
        for (int i = m; i < n; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        return dummy.next;
    }
}