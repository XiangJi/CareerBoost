package DSA.LinkedList.LinkedListCycleII;

import DSA.LinkedList.ListNode;

/*
 * 在有两个指针，第一个指针，每走一次走一步，第二个指针每走一次走两步，如果他们走了t次之后相遇在K点

那么       指针一  走的路是      t = X + nY + K        ①

             指针二  走的路是     2t = X + mY+ K       ②          m,n为未知数

把等式一代入到等式二中, 有

2X + 2nY + 2K = X + mY + K

=>   X+K  =  (m-2n)Y    ③

这就清晰了，X和K的关系是基于Y互补的。等于说，两个指针相遇以后，再往下走X步就回到Cycle的起点了。这就可以有O(n)的实现了。
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
                return null;
        }

        ListNode fast, slow;
        slow = head;
        fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                // write your detection here
                slow = head;
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }

        }
        return null;

    }
}