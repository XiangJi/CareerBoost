package DSA.SlidingWindow.LongestSubstringwithAtMostTwoDistinctCharacters;

import java.util.HashMap;

/*
 * 解法一：这种类型的题都应该用两个指针解决，同时用一个map来记录字符及其出现次数。
 * 一个右指针先移动，不断更新map,
 * 当发现map里的字符个数大于规定个数的时候，
 * 开始移动左指针，同时更新map,直到map里的字符个数等于规定个数，
 * 中间不断更新包含规定字符个数的最大长度。
 * 这道题的Follow up很直接，比如题目变为最多允许k个字符，该怎么处理？
 * 下面的代码直接把2改成k即可。
 *
 * 解法二：
 * 我们除了用哈希表来映射字符出现的个数，我们还可以映射每个字符最新的坐标，比如题目中的例子"eceba"，遇到第一个e，
 * 映射其坐标0，遇到c，映射其坐标1，遇到第二个e时，映射其坐标2，当遇到b时，映射其坐标3，每次我们都判断当前哈希表中的映射数，
 * 如果大于2的时候，那么我们需要删掉一个映射，我们还是从left=0时开始向右找，我们看每个字符在哈希表中的映射值是否等于当前坐标left，
 * 比如第一个e，哈希表此时映射值为2，不等于left的0，那么left自增1，遇到c的时候，哈希表中c的映射值是1，
 * 和此时的left相同，那么我们把c删掉，left自增1，再更新结果，以此类推直至遍历完整个字符串，参见代码如下：
 */

// Use method 2 here:
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // Save char and index 存法和LC3一致 用到map size
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left= 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);

            while(map.size() > 2) {
                // 如果等于左边界, 找到了要删掉的
                if (map.get(s.charAt(left)) == left) {
                    map.remove(s.charAt(left));
                }
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}