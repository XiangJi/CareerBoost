# Sliding window

When to use it?

Where the inuition come from?

本质上是在做substring问题的优化

要用到map.size(), 注意map也是个collection 所以基本方法都有



可以存个数 或者 index两种存法

### 应用场景

substring问题



## Code template

```java
/*我们除了用哈希表来映射字符出现的个数，我们还可以映射每个字符最新的坐标，比如题目中的例子"eceba"，遇到第一个e，
 * 映射其坐标0，遇到c，映射其坐标1，遇到第二个e时，映射其坐标2，当遇到b时，映射其坐标3，每次我们都判断当前哈希表中的映射数，
 * 如果大于2的时候，那么我们需要删掉一个映射，我们还是从left=0时开始向右找，我们看每个字符在哈希表中的映射值是否等于当前坐标left，
 * 比如第一个e，哈希表此时映射值为2，不等于left的0，那么left自增1，遇到c的时候，哈希表中c的映射值是1，
 * 和此时的left相同，那么我们把c删掉，left自增1，再更新结果，以此类推直至遍历完整个字符串
 */
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // Save char and index
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left= 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);

            while(map.size() > k) {
                // Delete the oldest key
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
```



### Practice

Minimum window substring <- find all anagrams in a string, tricky!!!

Longest substring 问题 3题都做 -> HashMap<Character, index>哈希表的存法

