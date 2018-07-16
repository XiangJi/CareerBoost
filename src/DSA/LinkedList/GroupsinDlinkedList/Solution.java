package DSA.LinkedList.GroupsinDlinkedList;

import java.util.HashSet;
import java.util.List;

/*
 * double linked list: 1，2，3，4，5. 
subset : {1,2,5}. more info on 1point3acres
问这个subset的点能构成几个group（相连为一个group）

12 和 5
2 个
没有head指针
用Union Find, 这里并查集明显overkill了

或者hashMap存是不是整体的个数
直接随便选一个然后在linkedlist里左右延伸 边延伸边删除set里元素 直到两头都不在set里 然后重复操作直到set为空

电面面经 + Onsite面经
doubly linked list, 给定几个节点，判断总共一共有几个strongly connected components （只能从给定的节点走）

一个double linked list 有的node是连着的 求block的个数

这几个月高频

LinkedListComponent的拓展
 */

class DoublyListNode {
    int val;
    DoublyListNode prev;
    DoublyListNode next;
    public DoublyListNode(int x) {
        val = x;
        prev = null;
        next = null;
    }
}
public class Solution {
    public int findGroups(List<DoublyListNode> nodes) {
        int res = 0;
        HashSet<DoublyListNode> set = new HashSet<>();
        for (DoublyListNode node : nodes) {
            DoublyListNode current = node;
            res++;
            if (set.contains(current.next)) {
                res--;
            }
            if (set.contains(current.prev)) {
                res--;
            }
            set.add(current);
        }   
        return res;
        
    }
}
