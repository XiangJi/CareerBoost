package DSA.Greedy.SplitArrayintoConsecutiveSubsequences;

import java.util.HashMap;
import java.util.Map;

/*
 * You are given an integer array sorted in ascending order (may contain duplicates), you need to split them into several subsequences, where each subsequences consist of at least 3 consecutive integers. Return whether you can make such a split.

Example 1:
Input: [1,2,3,3,4,5]
Output: True
Explanation:
You can split them into two consecutive subsequences :
1, 2, 3
3, 4, 5
Example 2:
Input: [1,2,3,3,4,4,5,5]
Output: True
Explanation:
You can split them into two consecutive subsequences :
1, 2, 3, 4, 5
3, 4, 5
Example 3:
Input: [1,2,3,4,4,5]
Output: False
Note:
The length of the input is in range of [1, 10000]

 * 类似打牌游戏
 *
 * 这道题就用贪婪解法就可以了，我们使用两个哈希表map，
 * 第一个map用来建立数字和其出现次数之间的映射freq，
 * 第二个用来建立可以加在某个连续子序列后的数字及其可以出现的次数之间的映射need。
 * 对于第二个map，举个例子来说，就是假如有个连，[1,2,3]，那么后面可以加上4，所以就建立4的映射。
 * 这样我们首先遍历一遍数组，统计每个数字出现的频率，然后我们开始遍历数组，对于每个遍历到的数字，
 * 首先看其当前出现的次数，如果为0，则继续循环；如果need中存在这个数字的非0映射，那么表示当前的数字
 * 可以加到某个连的末尾，我们将当前数字的映射值自减1，然后将下一个连续数字的映射值加1，因为当[1,2,3]
 * 连上4后变成[1,2,3,4]之后，就可以连上5了；如果不能连到其他子序列后面，我们来看其是否可以成为新的子序列
 * 的起点，可以通过看后面两个数字的映射值是否大于0，都大于0的话，说明可以组成3连儿，
 * 于是将后面两个数字的映射值都自减1，还有由于组成了3连儿，在need中将末尾的下一位数字的映射值自
 * 增1；如果上面情况都不满足，说明该数字是单牌，只能划单儿，直接返回false。最后别忘了将当前数字的freq
 * 映射值自减1。退出for循环后返回true，
 *
 * We iterate through the array once to get the frequency of all the elements in the array
We iterate through the array once more and for each element we either see if it can
be appended to a previously constructed consecutive sequence or if it can be the start
 of a new consecutive sequence. If neither are true, then we return false.

 */
public class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(), need = new HashMap<>();
        // count number
        for (int i : nums)
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        for (int i : nums) {
            if (freq.get(i) == 0)
                continue;
            else if (need.getOrDefault(i, 0) > 0) {
                need.put(i, need.get(i) - 1);
                need.put(i + 1, need.getOrDefault(i + 1, 0) + 1);
            } else if (freq.getOrDefault(i + 1, 0) > 0 && freq.getOrDefault(i + 2, 0) > 0) {
                // put new string
                freq.put(i + 1, freq.get(i + 1) - 1);
                freq.put(i + 2, freq.get(i + 2) - 1);
                need.put(i + 3, need.getOrDefault(i + 3, 0) + 1);
            } else
                return false;
            freq.put(i, freq.get(i) - 1);
        }
        return true;
    }
}
