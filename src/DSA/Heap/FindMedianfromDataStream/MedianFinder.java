package DSA.Heap.FindMedianfromDataStream;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 *
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2
heap 应用
O(1) 最大最小
插入式lgN
这题起码要lgN

不是TreeMap AVL self balanced BST logN search and insertion

算法是用min max两个heap
要balance两个heap大小
0<= <=1
median是从smaller heap的max 和larger heap的min找 根据odd even定答案
 */
class MedianFinder {

    private PriorityQueue<Long> min; // larger half
    private PriorityQueue<Long> max; // smaller half max heap

    public MedianFinder() {  // MedianFinder()
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(1000, Collections.reverseOrder());
    }

    public void addNum(int num) {

        max.offer((long)num);
        min.offer(max.poll());
        // balance code
        if (max.size() < min.size()) {
            max.offer(min.poll());
        }
    }

    public double findMedian() {
        if (max.size() == min.size()) return (max.peek() + min.peek()) /  2.0;
        else return max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */