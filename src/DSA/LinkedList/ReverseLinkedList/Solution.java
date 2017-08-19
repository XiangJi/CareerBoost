package DSA.LinkedList.ReverseLinkedList;

import DSA.LinkedList.ListNode;

public class Solution {

    /*
     * Assume that we have linked list 1 → 2 → 3 → Ø, we would like to change it to Ø ← 1 ← 2 ← 3.
     * While you are traversing the list, change the current node's next pointer to point to its previous element.
     *  Since a node does not have reference to its previous node, you must store its previous element beforehand.
     *  You also need another pointer to store the next node before changing the reference. Do not forget to return the new head reference at the end!
     *  Time complexity : O(n). Assume that nn is the list's length, the time complexity is O(n).
     *  Space complexity : O(1).


     */

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /*
     * Recursive
     * Be very careful that n1's next must point to Ø.
     * If you forget about this, your linked list has a cycle in it. This bug could be caught if you test your code with a linked list of size 2.
     */
    public ListNode reverseList2(ListNode head) {
        return helper(null, head);
    }
    public ListNode helper(ListNode reversed, ListNode remained) {
        if (remained == null) {
            return reversed;
        }
        ListNode tmp = remained.next;
        remained.next = reversed;

        return helper(remained, tmp);
    }
}
