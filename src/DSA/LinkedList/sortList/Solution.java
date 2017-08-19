package DSA.LinkedList.sortList;

import DSA.LinkedList.ListNode;

//Sort a linked list in O(n log n) time using constant space complexity.

//Given 1-3->2->null, sort it to 1->2->3->null.

//merge sort? quick sort?

//DC, 1. find the middle 2. break 3. sort n/2 4. merge
//Sort a linked list in O(n log n) time using constant space complexity.
//n level * log n for every level

//fast slow steps: fast speed 2, slow speed 1

public class Solution {
 /**
  * @param head: The head of linked list.
  * @return: You should return the head of the sorted linked list,
                 using constant space complexity.
  */
     private ListNode findMiddle(ListNode head) {
             if (head == null || head.next == null) {
                     return head;
             }

             ListNode slow = head, fast = head.next;
             while (fast != null && fast.next != null) {
                     fast = fast.next.next; // step = 2
                     slow = slow.next;      // step = 1
             }
             return slow; // which is the middle node
     }

     private ListNode merge(ListNode head1, ListNode head2) {
             ListNode dummy = new ListNode(-1);
             ListNode tail = dummy;

             // merge sort
             while (head1 != null && head2 != null) {
                     if (head1.val < head2.val) {
                             tail.next = head1;
                             head1 = head1.next;
                     } else {
                             tail.next = head2;
                             head2 = head2.next;
                     }
                     tail = tail.next;
             }

             // the last one define
             if (head1 != null) {
                     tail.next = head1;
             } else {
                     tail.next = head2;
             }

             return dummy.next;
     }
     // define: sort the list
 public ListNode sortList(ListNode head) {
     if (head == null || head.next == null) {
             return head;
     }

     ListNode mid = findMiddle(head);

     ListNode right = sortList(mid.next);
     mid.next = null; // need cut the linked list here
     ListNode left = sortList(head);

     return merge(left, right);
 }
}