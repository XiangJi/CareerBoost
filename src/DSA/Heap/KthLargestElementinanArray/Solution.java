package DSA.Heap.KthLargestElementinanArray;

import java.util.PriorityQueue;

/*
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
For example,
Given [3,2,1,5,6,4] and k = 2, return 5.


Important problem:

1. Use heap
2. Use quick Sort's partition (part of quick sort), remember hard! 思想就是游标 模版是掌握一个非递归的代码

 */
public class Solution {
    /*
     * T: O(nlogk) S: O(k)
     */
    public int findKthLargestII(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int pos = partition(nums, left, right);
            if (pos == k - 1) {
                return nums[pos];
            } else if (pos > k - 1) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            // sort big to small
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] >= pivot)
                l++;
            if (nums[r] <= pivot)
                r--;
        }
        swap(nums, left, r);
        return r; // the one the one left of pivot
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        // 最小的元素在队列的头部因而最先被取出,最小的值永远在root的树
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] array = { 7, 6, 1, 3, 4, 2, 5 };
        for (int num : array) {
            minHeap.offer(num);
            System.out.println(minHeap);
        }

    }
}
