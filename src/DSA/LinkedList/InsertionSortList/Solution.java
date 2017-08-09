package DSA.LinkedList.InsertionSortList;

import DSA.LinkedList.ListNode;

//Sort a linked list using insertion sort.
//Insert sort: 每一次看一个值放到前面合适位置，前面一直维护一个有序序列 (局部有序)

public class Solution {
 /**
  * @param head: The first node of linked list.
  * @return: The head of linked list.
  */
 public ListNode insertionSortList(ListNode head) {
     if (head == null) {
             return head;
     }
     // head can be changed, so dummy node
     ListNode dummy = new ListNode(-1);

     // head is the out pointer
     // node is the inner pointer start
     while (head != null) {
             ListNode node = dummy; // inner loop pointer
             while (node.next != null && node.next.val < head.val) {
                     node = node.next; // in++ to find the insert position
             }
             // swap nodes (position) and head++;

             // save the next out pointer
             ListNode temp = head.next;

             // insert is into the position
             head.next = node.next;
             node.next = head;

             // go to the next head; AKA head++
             head = temp;
     }

     return dummy.next; // the result is the last new node
 }
}