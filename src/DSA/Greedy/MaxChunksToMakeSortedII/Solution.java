package DSA.Greedy.MaxChunksToMakeSortedII;
/*
 * 那道题说了数组是[0, n-1]中所有数字的一种全排列，n为数组的长度。而这道题的数字就没有这种限制，可以是大于n的数字，也可以有重复的数字。由于数字和坐标不再有太多的关联，所以之前那题中比较数字和坐标的大小的解法肯定行不通了。我们来看一种十分巧妙的解法，首先我们需要明确的一点是，拆分后的块儿排序后拼在一起会跟原数组相同，
 * 
 * 我们需要两个数组forward和backward，其中 foward[i] 表示 [0, i] 范围内最大的数字，而 backward[i] 表示 [i, n-1] 范围内最小的数字，实际上就是要知道已经遍历过的最大值，和还未遍历的到的最小值。为啥我们对这两个值感兴趣呢？这是本解法的精髓所在，我们知道可以拆分为块儿的前提是之后的数字不能比当前块儿中的任何数字小，不然那个较小的数字就无法排到前面。就像例子1，为啥不能拆出新块儿，就因为最小的数字在末尾。那么这里我们能拆出新块儿的条件就是，当前位置出现过的最大值小于等于之后还未遍历到的最小值时，就能拆出新块儿。比如例子2中，当 i=1 时，此时出现过的最大数字为2，未遍历到的数字中最小值为3，所以可以拆出新块儿，
 * 
 * 有点像best buy III的dp解法
 */
public class Solution {
    public int maxChunksToSorted(int[] arr) {
            int res = 1, n = arr.length;
            int[] f = arr.clone();
            int[] b = arr.clone();   
            for (int i = 1; i < n; ++i) f[i] = Math.max(arr[i], f[i - 1]);   
            for (int i = n - 2; i >= 0; --i) b[i] = Math.min(arr[i], b[i + 1]);
            for (int i = 0; i < n - 1; ++i) {
                if (f[i] <= b[i + 1]) ++res;
            }
            return res;
        }
}
