package DSA.Interval.InsertInterval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import DSA.Interval.MergeIntervals.Interval;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class Solution {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    // Hard implementation 背诵题
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        if (intervals == null || newInterval == null) {
                return intervals;
        }
        int addPosition = 0;
        List<Interval> result = new ArrayList<Interval>();
        // put thing into ArrayList from middle, add(index, thing)
        for (Interval range : intervals) {
                if (range.end < newInterval.start) {
                        result.add(range);
                        addPosition++;
                } else if (range.start > newInterval.end) {
                        result.add(range);
                } else { // need merge, and skip the previous add
                        newInterval.start = Math.min(range.start, newInterval.start);
                        newInterval.end = Math.max(range.end, newInterval.end);
                }
        }
        result.add(addPosition, newInterval);
        return result;
    }

    // smart solution as a merge interval follow up
    public List<Interval> insertII(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);

        List<Interval> ans = new ArrayList<>();

        intervals.sort(Comparator.comparing(i -> i.start));  //lambda 匿名函数：输入i  返回i.start

        /*
         * Collections.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval i1, Interval i2) {
                        return i1.start - i2.start;
                }
        });
         */
        Interval last = null;
        for (Interval item : intervals) {
            if (last == null || last.end < item.start) {
                ans.add(item);
                last = item;
            } else {
                last.end = Math.max(last.end, item.end); // Modify the element already in list
            }
        }
        return ans;
    }
}