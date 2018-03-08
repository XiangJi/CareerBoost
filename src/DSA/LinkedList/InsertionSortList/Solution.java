package DSA.LinkedList.InsertionSortList;

import DSA.LinkedList.ListNode;

//Sort a linked list using insertion sort.
//Insert sort: 每一次看一个值放到前面合适位置，前面一直维护一个有序序列 (局部有序)

public class Solution {
    /**
     * @param head:
     *            The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        // head can be changed, so dummy node, which is the new head
        ListNode dummy = new ListNode(-1);
        ListNode current = head;
        // head is the out pointer
        // node is the inner pointer start
        while (current != null) {
            ListNode node = dummy; // inner loop pointer, everytime point to the
                                   // new head
            while (node.next != null && node.next.val < current.val) {
                node = node.next; // in++ to find the insert position
            }
            // add the nodes (position) into the new list and head++;

            // save the next out pointer
            ListNode temp = current.next;

            // insert is into the position
            current.next = node.next;
            node.next = current;

            // go to the next head; AKA head++
            current = temp;
        }

        return dummy.next; // the result is the last new node
    }
}