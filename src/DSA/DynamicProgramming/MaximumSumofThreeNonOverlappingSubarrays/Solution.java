package DSA.DynamicProgramming.MaximumSumofThreeNonOverlappingSubarrays;

/*
 * In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.

Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.

Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.

Example:
Input: [1,2,1,2,6,7,5,1], 2
Output: [0, 3, 5]
Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
Note:
nums.length will be between 1 and 20000.
nums[i] will be between 1 and 65535.
k will be between 1 and floor(nums.length / 3).


对于这种求子数组和有关的题目时，一般都需要建立累加和数组，为啥呢，因为累加和数组可以快速的求出
任意长度的子数组之和，当然也能快速的求出长度为k的子数组之和。因为这道题只让我们找出三个子数组，
那么我们可以先确定中间那个子数组的位置，这样左右两边的子数组的位置范围就缩小了，中间子数组的起
点不能是从开头到结尾整个区间，必须要在首尾各留出k个位置给其他两个数组。一旦中间子数组的起始位置
确定了，那么其和就能通过累加和数组快速确定。那么现在就要在左右两边的区间内分别找出和最大的子数组，遍历所有的子数组显然不是很高效，如何快速求出呢，这里我们需要使用动态规划Dynamic Programming的思想来维护两个DP数组left和right，其中:

left[i]表示在区间[0, i]范围内长度为k且和最大的子数组的起始位置

right[i]表示在区间[i, n - 1]范围内长度为k且和最大的子数组的起始位置

这两个dp数组各需要一个for循环来更新，left数组都初始化为0，前k个数字没办法，肯定起点都是0，变量
total初始化为前k个数字之和，然后从第k+1个数字开始，每次向前取k个，利用累加和数组sums快速算出数
字之和，跟total比较，如果大于total的话，那么更新total和left数组当前位置值，否则的话left数组的
当前值就赋值为前一位的值。同理对right数组的更新也类似，total初始化为最后k个数字之和，
然后从前一个数字向前遍历，如果大于total，更新total和right数组的当前位置，
否则right数组的当前值就赋值为后一位的值。一旦left数组和right数组都更新好了，
那么就可以遍历中间子数组的起始位置了，然后我们可以通过left和right数组快速定位出左边和右边的
最大子数组的起始位置，并快速计算出这三个子数组的所有数字之和，用来更新全局最大值mx，如果mx被更
新了的话，记录此时的三个子数组的起始位置到结果res中

O(n)
 */
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if(nums==null || nums.length==0) {
            return null;
        }
        int len = nums.length;

        // this is very important because otherwise i+k is going to out of bounds.
        int[] sum = new int[len+1];
        int[] left = new int[len];
        int[] right = new int[len];
        int[] res = new int[3];
        int max = 0;

        // Computing the running sum
        // sum[i] stores the value from index 0 to i-1
        for (int i=0; i<len; i++) {
            sum[i+1] = sum[i] + nums[i];
        }

        // traversing from left to right
        int leftMax = sum[k]-sum[0];
        left[k-1] = 0;
        for (int i=k; i<len; i++) {
            if (sum[i+1] - sum[i+1-k] > leftMax) {
                left[i] = i-k+1;
                leftMax = sum[i+1] - sum[i+1-k];
            } else {
                left[i] = left[i-1];
            }
        }

        // traversing from right to left
        int rightMax = sum[len] - sum[len-k];
        right[len-k] = len-k;
        for (int i=len-k-1; i>=0; i--) {
            if (sum[i+k] - sum[i] > rightMax) {
                right[i] = i;
                rightMax = sum[i+k] - sum[i];
            } else {
                right[i] = right[i+1];
            }
        }

        // now consider the middle part where k<=i<=n-2k
        for (int i=k; i<=len-2*k; i++) {
            int l = left[i-1];
            int r = right[i+k];
            int total = (sum[l+k] - sum[l]) + (sum[i+k] - sum[i]) + (sum[r+k] - sum[r]);
            if (total > max) {
                max = total;
                res[0] = l;
                res[1] = i;
                res[2] = r;
            }
        }
        return res;
    }
}