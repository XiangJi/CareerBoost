package DSA.BinarySearch.FindKthSmallestPairDistance;

import java.util.Arrays;

/*
 * Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.

Example 1:
Input:
nums = [1,3,1]
k = 1
Output: 0
Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
Note:
2 <= len(nums) <= 10000.
0 <= nums[i] < 1000000.
1 <= k <= len(nums) * (len(nums) - 1) / 2.

NlogW+NlogN

暴力方法用heap (k+N )logN

小结中的第四种，即二分法的判定条件不是简单的大小关系，而是可以抽离出子函数的情况，下面我们来看具体怎么弄。我们的目标是快速定位出第k小的距离，那么很适合用二分法来快速
的缩小查找范围，然而最大的难点就是如何找到判定依据来折半查找，即如果确定搜索目标是在左半边还是右半边。做过Kth Smallest Element in a Sorted Matrix和Kth 
Smallest Number in Multiplication Table这两道题的同学应该对这种搜索方式并不陌生。核心思想是二分确定一个中间数，然后找到所有小于等于这个中间数的距离个数，
用其跟k比较来确定折半的方向。具体的操作是，我们首先要给数组排序，二分搜索的起始left为0，结束位置right为最大距离，即排序后的数字最后一个元素减去首元素。然后进入while循环
和start，其中cnt是记录小于等于mid的距离个数，start是较小数字的位置，均初始化为0，然后我们遍历整个数组，先进行while循环，如果start未越界，并且当前数字减去start指向
的数组之差大于mid，说明此时距离太大了，我们增加减数大小，通过将start右移一个，那么while循环退出后，就有i - start个距离小于等于mid，将其加入cnt中，举个栗子来说：

   1    2    3    3    5

start              i

mid = 2

如果start在位置0，i在位置3，那么以nums[i]为较大数可以产生三个（i - start）小于等于mid的距离，[1 3], [2 3], [3 3]，这样当i遍历完所有的数字后，
所有小于等于mid的距离的个数就求出来了，即cnt。然后我们跟k比较，如果其小于k，那么left赋值为mid+1，反之，则right赋值为mid。最终返回right或left均可，
 */
class Solution {
    // Returns number of pairs with absolute difference less than or equal to mid.
    private int countPairs(int[] a, int mid) {
        int n = a.length, res = 0;
        for (int i = 0; i < n; ++i) {
            int j = i;
            while (j < n && a[j] - a[i] <= mid) j++;
            res += j - i - 1;
        }
        return res;
    }

    public int smallestDistancePair(int a[], int k) {
        int n = a.length;
        Arrays.sort(a);

        // Minimum absolute difference
        int low = a[1] - a[0];
        for (int i = 1; i < n - 1; i++)
            low = Math.min(low, a[i + 1] - a[i]);

        // Maximum absolute difference
        int high = a[n - 1] - a[0];

        // Do binary search for k-th absolute difference
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairs(a, mid) < k)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}