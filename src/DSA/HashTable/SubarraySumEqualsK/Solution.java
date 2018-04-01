package DSA.HashTable.SubarraySumEqualsK;

import java.util.HashMap;

/*
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2

BF: N ^ 2
Subarray-> use preflix sum
Use hash set to save one pass
Use hash map to count the sum, since negative integer may cause same sum
use getOrDefault to save if statement
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int result = 0;
        // map: sum, count since maybe multiple sum qualified
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            
        }
        return result;
    }
}