# Sort

常见的排序算法根据是否需要比较可以分为如下几类：

- Comparison Sorting

1. Bubble Sort
2. Selection Sort
3. Insertion Sort
4. Shell Sort
5. Merge Sort
6. Quick Sort
7. Heap Sort

- Bucket Sort
- Counting Sort
- Radix Sort



不要老是先想数据结构 很多时候greedy法的时候

需要按规则直接讲数组sort

要会写comparator和lamda expression

```java
Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String X = a + b;
                String Y = b + a;
                return Y.compareTo(X) > 0 ? 1: - 1;
            }
        });
```

Lamda expression, (a, b) -> (the return value of compare function), if computation is complex here, then write a com



### Code template

```java
// merge sort
void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves，
            //如果已经排序好了就不用sort了比如mergeKLinkedList
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
// quick sort
public static void quickSort(int[] array,int start,int end)
    {
        if(start < end)
        {
            int key = array[start];//初始化保存基元
            int i = start,j;//初始化i,j
            for(j = start + 1;j <= end;j++)
            {
                if(array[j]<key)//如果此处元素小于基元，则把此元素和i+1处元素交换，并将i加1，如大于或等于基元则继续循环
                {
                    int temp = array[j];
                    array[j] = array[i+1];
                    array[i+1] = temp;
                    i++;
                }
                
            }
            array[start] = array[i];//交换i处元素和基元
            array[i] = key;
            quickSort(array, start, i-1);//递归调用
            quickSort(array, i+1, end);
            
        }
// insert sort
    //Insert sort: 每一次看一个值放到前面合适位置，前面一直维护一个有序序列 (局部有序)

public class Solution {
    /**
     * @param head:
     *            The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        // head can be changed, so dummy node, which is the new head
        ListNode dummy = new ListNode(-1);
        ListNode current = head;
        // head is the out pointer
        // node is the inner pointer start
        while (current != null) {
            ListNode node = dummy; // inner loop pointer, everytime point to the
                                   // new head
            while (node.next != null && node.next.val < current.val) {
                node = node.next; // in++ to find the insert position
            }
            // add the nodes (position) into the new list and head++;

            // save the next out pointer
            ListNode temp = current.next;

            // insert is into the position
            current.next = node.next;
            node.next = current;

            // go to the next head; AKA head++
            current = temp;
        }

        return dummy.next; // the result is the last new node
    }
}
```



### Practice

Relative ranks

wiggle sort