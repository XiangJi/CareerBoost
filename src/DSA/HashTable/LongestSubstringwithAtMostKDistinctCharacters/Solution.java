package DSA.HashTable.LongestSubstringwithAtMostKDistinctCharacters;

import java.util.HashMap;

// 高频 电面 onsite都有
/*
 * int getSubstring（String S，int M）. visit 1point3acres for more.
返回字符串中最多还有M个不同字符的最长子串
我用的是two pointers + HashMap <Character, Integer>, map的value是对应字符在子串中的最后一次出现的位置
Follow-ups
1. corner case：(1) M<0 (2) S==null (我都没有想到，同志们要注意)
2. 复杂度： O（MN） （N：字符串长度；M：因为每次更新left pointer时，要遍历map，找到最小的value）
3. 如何降低：priority queue (lookup O(1); insert: O(log M))
4. 如何进一步降低：priority queue + hashmap, 用double linked list 做priority queue，用map保存（value，node）pairs， 实现lookup O(1); insert: O(1)
5. 最后面试官指明，这其实是一个LRUcache，恍然大悟

 */

/*
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.

用sliding window秒了 Time O(2n), Space O(n)
follow up: How about stream input (infinite input) 用Mapreduce秒了
follow upup: Any other solution？
1. 数学归纳法 O(n) space O(k)
2. KMP


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