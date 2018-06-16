package DSA.Interval.MissingRanges;
/*
 * Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

Example:

Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]

高频实现题目
考察细节
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();

        if (nums.length == 0) {
            addRange(result, lower, upper);
            return result;
        }
        // convert to long when number may be out of int bound
        addRange(result, lower, (long) nums[0] - 1);

        for (int i = 1; i < nums.length; i++) {
            addRange(result, (long) nums[i - 1] + 1, (long) nums[i] - 1);
        }
        addRange(result, (long) nums[nums.length - 1] + 1, upper);

        return result;
    }

    private void addRange(List<String> array, long start, long end) {
        if (start > end) {
            return;
        }
        if (start == end) {
            array.add(start + "");
            return;
        }
        array.add(start + "->" + end);
    }
}