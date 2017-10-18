package DSA.Sort.RelativeRanks;

import java.util.Arrays;

/*
 * Given scores of N athletes, find their relative ranks and the
 *  people with the top three highest scores, who will be awarded
 *  medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 *
 * Basically this question is to find out the score -> ranking mapping.
 * The easiest way is to sort those scores in nums. But we will
 * lose their original order. We can create (score , original index) pairs and sort them by score decreasingly.
 * Then we will have score -> ranking (new index) mapping and we can use original index to create the result.

Time complexity: O(NlgN). Space complexity: O(N).
N is the number of scores.
 */
public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        // Use Integer object instead of int since using Lamda/Comparator
        Integer[] index = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        // Lamda expression, same as comparator
//        Arrays.sort(index, new Comparator<Integer>{
//            @Override
//            public int compare(Integer a, Integer b){
//                return nums[b] - nums[a];
//            }
//         });

        Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));

        String[] result = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[index[i]] = "Gold Medal";
            }
            else if (i == 1) {
                result[index[i]] = "Silver Medal";
            }
            else if (i == 2) {
                result[index[i]] = "Bronze Medal";
            }
            else {
                result[index[i]] = (i + 1) + "";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {123,1234,345,4,7};
        Solution test = new Solution();
        test.findRelativeRanks(nums);
    }
}