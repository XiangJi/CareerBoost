package DSA.LinkedList.ReverseLinkedListII;

import DSA.LinkedList.ListNode;

public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if (m >= n || head == null) {
                return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;

        // define the head of m to n
        for (int i = 1; i < m; i++) {
                if (head == null) {
                        return null;
                }
                head = head.next;
        }

        // reverse
        ListNode premNode = head; // the node before mth node since using dummy node
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postnNode = mNode.next; // draw graph

        for (int i = m; i < n; i++) {
                if (postnNode == null) {
                        return null;
                }

                ListNode temp = postnNode.next;
                postnNode.next = nNode;
                nNode = postnNode;
                postnNode = temp;
        }
        //connection with the chain
        mNode.next = postnNode;
        premNode.next = nNode;


        return dummy.next;
    }
}