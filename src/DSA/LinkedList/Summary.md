# Linked list

Basic operation

Two pointers

fast slow pointers

空间想象 画图法

用head node保留一个引用，最后想返回什么就返回什么

Dummy node 用于头结点会改变的情况

prev指针 用于给node变换顺序

不断debug就可以 记住 next指针只不过也是listNode的一个数据而已



链表实际在考察的是指针操作 画图屡清楚就行 考得不太多因为比较简单

```java
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }
}

// reverse
1. t, cn, p, c
2. t, cn tn , pn
```



Important Operation:

```java
ListNode dummy
ListNode prev
ListNode slow
ListNode fast
```



### Practice

LRUCache

MergeKSortList

merge sort list

ReorderList

ReverseList I, ii