package DSA.Greedy.TaskScheduler;

import java.util.Arrays;

/*
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
Note:
The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].

花花酱 LeetCode 621：
Round Robin 来排序

用频率排序

k 是最高评率
n是最小cooldown间隔
p task has the same freq as max, 做为最后一轮的task
每个group是n+1个slot 如果task不够就使用空槽
ans = (k - 1) * (n + 1) + p

special case:

当task # > ans时候， 不需要插入idle 所以ans = task

前半部分都是一样的，求出最多的次数mx，还有同时出现mx次的不同任务的个数mxCnt。
这个解法的思想是先算出所有空出来的位置，然后计算出所有需要填入的task的个数，如果超出了空位的个数，
就需要最后再补上相应的个数。注意这里如果有多个任务出现次数相同，那么将其整体放一起，就像上面的第二个例子
中的CE一样，那么此时每个part中的空位个数就是n - (mxCnt - 1)，那么空位的总数就是part的总数乘以
每个part中空位的个数了，那么我们此时除去已经放入part中的，还剩下的task的个数就是task的总个数减去
mx * mxCnt，然后此时和之前求出的空位数相比较，如果空位数要大于剩余的task数，那么则说明还需补充多余的空位
，否则就直接返回task的总数即可，

 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c: tasks) {
            count[c - 'A']++;
        }

        Arrays.sort(count);
        int maxCount = count[25];
        int ans = (maxCount - 1) * (n + 1);
        // p task has the same freq as max, 做为最后一轮的task
        for (int i = 0; i < count.length; i++) {
            if (count[i] == maxCount) {
                ans += 1;
            }
        }
        return Math.max(ans, tasks.length);
    }
}