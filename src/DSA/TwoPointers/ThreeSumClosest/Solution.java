package DSA.TwoPointers.ThreeSumClosest;

import java.util.Arrays;

/*
 *
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * BB tag
 */
public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        if (numbers.length < 3 || numbers == null) {
                return Integer.MAX_VALUE;
        }
        Arrays.sort(numbers);
        int closet = Integer.MAX_VALUE / 2; // otherwise it will overflow for opeartion (closet-target)
        for (int i = 0; i < numbers.length - 2; i++) {
                int left = i + 1;
                int right = numbers.length - 1;
                while (left < right) {
                        int sum = numbers[left] + numbers[right] + numbers[i];
                        if (sum == target) {
                                return sum;
                        } else if (sum < target) {
                                left++;
                        } else {
                                right--;
                        }
                        closet = Math.abs(sum - target) > Math.abs(closet - target) ? closet : sum;
                }
        }
        return closet;
    }
}