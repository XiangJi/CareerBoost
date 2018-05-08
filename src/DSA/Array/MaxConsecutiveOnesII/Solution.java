package DSA.Array.MaxConsecutiveOnesII;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

Example 1:
Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    After flipping, the maximum number of consecutive 1s is 4.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
Follow up:
What if the input numbers come in one by one as an infinite stream? In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?


Stream mean read and write and the same time, cannot hold all data into memory
In this case, use queue, and only one pass

我们有一次将0翻转成1的机会，问此时最大连续1的个数，再看看follow up中的说明，很明显
是让我们只遍历一次数组，那我们想，肯定需要用一个变量cnt来记录连续1的个数吧，那么当遇到了0
的时候怎么处理呢，因为我们有一次0变1的机会，所以我们遇到0了还是要累加cnt，然后我们此时需要用另外
一个变量cur来保存当前cnt的值，然后cnt重置为0，
以便于让cnt一直用来统计纯连续1的个数，然后我们每次都用用cnt+cur来更新结果res


如果题目中说能翻转k次怎么办呢，我们最好用一个通解来处理这类问题。
我们可以维护一个窗口[left,right]来容纳至少k个0。我们遇到了0，就累加zero的个数，
然后判断如果此时0的个数大于k，那么我们我们右移左边界left，如果移除掉的nums[left]为0，
那么我们zero自减1。如果不大于k，那么我们用窗口中数字的个数来更新res，


int findMaxConsecutiveOnes(vector<int>& nums) {
        int res = 0, zero = 0, left = 0, k = 1;
        for (int right = 0; right < nums.size(); ++right) {
            if (nums[right] == 0) ++zero;
            while (zero > k) {
                if (nums[left++] == 0) --zero;
            }
            res = max(res, right - left + 1);
        }
        return res;
    }

    上面那种方法对于follow up中的情况无法使用，因为nums[left]需要访问之前的数字。
    我们可以将遇到的0的位置全都保存下来，这样我们需要移动left的时候就知道移到哪里了
    use queue


 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
         // use prev to store previous num of 1s
        int res = 0, count = 0, prev = 0;
        for (int i : nums) {
            count++;
            if (i == 0) {
                prev = count;
                count = 0;
            }
            res = Math.max(res, count + prev);
        }
        return res;
    }

    public int findMaxConsecutiveOnesII(int[] nums) {
        int res = 0, left = 0, k = 1;
        Queue<Integer> q = new LinkedList<>();
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                q.offer(right);
            }
            if (q.size() > k) {
                left = q.peek() + 1;
                q.poll();
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

}