package DSA.Interval.MergeIntervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 *
 *
 * */
class Solution {

    // basic algorithm: if overlap, merge, if not add the prev one
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> ans = new ArrayList<>();

        intervals.sort(Comparator.comparing(i -> i.start));  //lambda 匿名函数：输入i  返回i.start

        /* 熟练写comparator!
         * Collections.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval i1, Interval i2) {
                        return i1.start - i2.start;
                }
        });
         */
        // Use last pointer
        Interval last = null;
        for (Interval item : intervals) {
            if (last == null || last.end < item.start) {
                ans.add(item);
                last = item;
            } else {
                last.end = Math.max(last.end, item.end); // Modify the element already in list, last可以修改进res的区间
            }
        }
        return ans;
    }
}