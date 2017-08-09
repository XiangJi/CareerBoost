package DSA.LinkedList.CopyListwithRandomPointer;

import java.util.HashMap;

class RandomListNode {
    int            label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};

public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // copy the node and pointer bounds.
        if (head == null) {
            return head;
        }

        // double tranverse
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode pre = dummy;
        RandomListNode newNode;

        while (head != null) {
            if (map.containsKey(head)) {
                newNode = map.get(head);
            } else {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            pre.next = newNode;

            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    newNode.random = map.get(head.random);
                } else {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }

            }
            pre = newNode;
            head = head.next;
        }

        return dummy.next;
    }
}