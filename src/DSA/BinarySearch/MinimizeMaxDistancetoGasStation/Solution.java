package DSA.BinarySearch.MinimizeMaxDistancetoGasStation;
/*
 * On a horizontal number line, we have gas stations at positions stations[0], stations[1], ..., stations[N-1], where N = stations.length.

Now, we add K more gas stations so that D, the maximum distance between adjacent gas stations, is minimized.

Return the smallest possible value of D.

Example:

Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
Output: 0.500000

这道题使用的二分搜索法是博主归纳总结帖LeetCode Binary Search Summary 二分搜索法小结中的第四种，
即二分法的判定条件不是简单的大小关系，而是可以抽离出子函数的情况，下面我们来看具体怎么弄。如果光说要用二分法来做，
那么首先就要明确的是二分法用来查找什么，难道是用来查找要插入加油站的位置吗？很显然不是，其实是用来查找那个最小的任意两个加油站间的最大距离。
这其实跟之前那道Kth Smallest Element in a Sorted Matrix非常的类似，那道题的二分搜索也是直接去折半定位所求的数，
然后再来验证其是否真的符合题意。这道题也是类似的思路，题目中给了数字的范围[0, 10^8]，那么二分查找的左右边界值就有了，
又给了误差范围10^-6，那么只要right和left差值大于这个阈值，就继续循环。我们折半计算出来的mid就是一个candidate，
我们要去验证个candidate是否符合题意。验证的方法其实也不难，我们计算每两个加油站之间的距离，如果此距离大于candidate，
则计数器累加1，如果大于candidate距离的个数小于等于k，则说明我们的candidate偏大了，那么right赋值为mid；
反之若大于candidate距离的个数大于k，则说明我们的candidate偏小了，那么left赋值为mid。
最后left和right都会收敛为所要求的最小的任意两个加油站间的最大距离

Time Complexity: O(N \log W)O(NlogW), where NN is the length of stations, and W = 10^{14}W=10
​14
​​  is the range of possible answers (10^810
​8
​​ ), divided by the acceptable level of precision (10^{-6}10
​−6
​​ ).

 */
class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        double lo = 0, hi = 1e8;
        while (hi - lo > 1e-6) {
            double mi = (lo + hi) / 2.0;
            if (possible(mi, stations, K))
                hi = mi;
            else
                lo = mi;
        }
        return lo;
    }

    public boolean possible(double D, int[] stations, int K) {
        int used = 0;
        for (int i = 0; i < stations.length - 1; ++i)
            used += (int) ((stations[i+1] - stations[i]) / D);
        return used <= K;
    }
}
