package DSA.Interval.MeetingRooms;

import java.util.Arrays;
import java.util.Comparator;

import DSA.Interval.MergeIntervals.Interval;

/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 *  determine if a person could attend all meetings.
 *  For example,
 *  Given [[0, 30],[5, 10],[15, 20]],
 *  return false
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        //Sort first
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override // this is used when implementing interface
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }
        return true;
    }
}