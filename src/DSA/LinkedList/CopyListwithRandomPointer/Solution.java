package DSA.LinkedList.CopyListwithRandomPointer;

import java.util.HashMap;

/*
 * A linked list is given such that each node contains an additional
 * random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 *
 * 1. Use hash to store the relationship between original one and new one
 * 2. No hash
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode current = head;
        // copy node value
        while (current != null) {
            map.put(current, new RandomListNode(current.label));
            current = current.next;
        }
        current = head;
        // copy pointers
        while (current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next; // don't forget the move the index using
                                    // while loop
        }
        return map.get(head);
    }

    /*
     * No HashMap
     * 第一遍扫的时候巧妙运用next指针， 开始数组是1->2->3->4 然后扫描过程中 先建立copy节点
     * 1->1`->2->2`->3->3`->4->4`, 然后第二遍copy的时候去建立边的copy， 拆分节点,
     * 一边扫描一边拆成两个链表，这里用到两个dummy node。第一个链表变回 1->2->3 , 然后第二变成 1`->2`->3`
     */
    public RandomListNode copyRandomListII(RandomListNode head) {
        RandomListNode cur = head;
        RandomListNode next;
        //copy next, build the 1-1' lists
        while (cur != null) {
            next = cur.next;
            RandomListNode copy = new RandomListNode(cur.label);
            cur.next = copy;
            copy.next = next;
            cur = next;
        }
        //copy random pointers
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // finish the copy with pointers, now split
        cur = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copy;
        RandomListNode copycur = dummy;
        // split into two lists
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            copycur.next = copy;
            copycur = copy;
            cur.next = next;
            cur = next;
        }
        return dummy.next;
    }

}