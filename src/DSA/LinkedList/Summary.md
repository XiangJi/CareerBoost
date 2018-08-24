# Linked list

Basic operation

Two pointers

fast slow pointers

空间想象 画图法

用head node保留一个引用，最后想返回什么就返回什么

Dummy node 用于头结点会改变的情况

prev指针 用于给node变换顺序，一般这种题 prev来保留之前的element tmp/current.next来保留后一个

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

注意这边的写法和swap一样 就是后一个是新一行的开头
```



Important Operation:

```java
ListNode dummy // for store the head if head will be changed
ListNode prev // for store the prev
ListNode cur // as cursor
ListNode temp // for store next
ListNode slow
ListNode fast
```



### Practice

LRUCache

MergeKSortList

merge sort list

ReorderList

ReverseList I, ii