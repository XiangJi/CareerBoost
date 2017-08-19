package DSA.LinkedList.DeleteNodeinaLinkedList;

import DSA.LinkedList.ListNode;

// // 这题无法操纵head，所以没法遍历，也没有办法操纵这个点前面的那个点，所以直接找把后面点复制上来，然后这个点指后面的后面
public class Solution {
   public void deleteNode(ListNode node) {
       if (node == null) {
           return;
       }
       node.val = node.next.val;
       node.next = node.next.next;
   }
}