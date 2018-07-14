package DSA.Interval.MeetingRoomsII;

import java.util.Arrays;

import DSA.Interval.MergeIntervals.Interval;

/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1


MapReduce
数据量特别大就是 分成小块 在不同的机器上运算，然后把边界值传给其他的机器做下一轮；

运算性能不一样 就是有一个master 控制各个worker每次做一次操作，如果有做的快的就roll back回

graph partition

Follow up:
需要返回每个room占用的具体时间

sweep line, boundary count, just like my calendar 3
这种更trick一点 要记住
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int m = intervals.length;
        if (m == 0) {
            return 0;
        }
        int[] start = new int[m];
        int[] end = new int[m];
        

        for (int i = 0; i < m; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        // sort!
        Arrays.sort(start);
        Arrays.sort(end);
        
        int room = 0;
        int j = 0; // yes is used for track the last session
        for (int i = 0; i < m; i++) {
            if (start[i] < end[j]) {
                room++;
            } else {
                j++;
            }
        }
        return room;
    }
    
    // 也可以用treemap来boundary count
}
