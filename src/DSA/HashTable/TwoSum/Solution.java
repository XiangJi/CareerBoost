package DSA.HashTable.TwoSum;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        if (nums == null) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(target - nums[i], i);
            } else {
                result[0] = map.get(nums[i]);
                result[1] = i;
            }
        }
        return result;
    }
}