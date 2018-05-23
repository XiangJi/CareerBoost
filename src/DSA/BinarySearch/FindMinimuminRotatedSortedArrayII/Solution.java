package DSA.BinarySearch.FindMinimuminRotatedSortedArrayII;

// if contains dup, O(N)

//version 1: just for loop is enough
public class Solution {
 public int findMin(int[] num) {
     //  这道题目在面试中不会让写完整的程序
     //  只需要知道最坏情况下 [1,1,1....,1] 里有一个0
     //  这种情况使得时间复杂度必须是 O(n)
     //  因此写一个for循环就好了。
     //  如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情况的情况，那你就写一个二分吧。
     //  反正面试考的不是你在这个题上会不会用二分法。这个题的考点是你想不想得到最坏情况。
     int min = num[0];
     for (int i = 1; i < num.length; i++) {
         if (num[i] < min)
             min = num[i];
     }
     return min;
 }
}