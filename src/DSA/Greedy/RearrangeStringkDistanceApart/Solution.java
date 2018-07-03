package DSA.Greedy.RearrangeStringkDistanceApart;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.
 * All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1:

str = "aabbcc", k = 3

Result: "abcabc"

The same letters are at least distance 3 from each other.
 * 基于贪心的, 先统计每个字符的数量, 为了让字符排列更紧凑, 借助一个优先队列先排列个数大的字符
Like 打牌贪心
1. 如果剩余的字符的数量大于k, 那么就需要在接下来排列k个不同的字符, 并将这k个不同字符个数都-1, 如果在排这k个不同字符的时候发现并没有k个不同字符, 说明是无法得到答案的. 

2. 如果剩余的字符数量不到k, 那么就在接下排列剩余个数的不同字符. 方法和上面一样.

在优先队列中存储以(数量+字符)的对, 以k为区间大小排列k个从数量高到低的字符, 然后再重复此过程, 这种贪心的策略可以保证让数量大的最优先排列, 并且使其间隔最小的距离, 否则到后来可能没有足够的空间.

虽然在while循环里面还有一个for循环，但是仔细分析我们就可以发现，所有循环的执行次数加起来刚好是字符串s的长度，因为每执行一次循环result的长度就增加1。所以算法的时间复杂度是O(n)，空间复杂度是O(m)，m是s中不同字符的个数

nlogn  n
 */
class Solution {
    public String rearrangeString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        // 可以把整个map放进去 也可以只放char, max heap
        PriorityQueue<Character> heap =  new PriorityQueue<>( (a, b) -> map.get(b) - map.get(a));
        heap.addAll(map.keySet());
        // Use wait queue for each iteration of k elements
        Queue<Character> queue = new LinkedList<>();
        while(!heap.isEmpty()) {
            Character c = heap.poll();
            sb.append(c);
            map.put(c, map.get(c) - 1);
            queue.offer(c);
            // filling the k iteration
            if (queue.size() < k) {
                continue;
            }
            // Release from waitQueue if char is already k apart
            Character front = queue.poll();
            if (map.get(front) > 0) {
                heap.offer(front);
            }
        }
        
        return sb.length() == s.length() ? sb.toString() : "";
    }
}
