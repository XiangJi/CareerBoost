package DSA.Array.SummaryRanges;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:
Input: [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Example 2:
Input: [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]

Simulation problem ,just brute force
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums.length == 0 || nums == null) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (start != nums[i]) {
                result.add(start + "->" + nums[i]);
            } else {
                result.add(start + ""); // auto convert to string
            }
        }
        return result;
    }
}