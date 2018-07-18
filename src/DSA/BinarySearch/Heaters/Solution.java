package DSA.BinarySearch.Heaters;

import java.util.Arrays;
/*
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

 Input: [1,2,3],[2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard,
 *
 */
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = -1;
        int current = 0;
        for (int i = 0; i < houses.length; i++) {
            int start = 0;
            int end = heaters.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (heaters[mid] > houses[i]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            // 对每个房子都找到一个最近的heaters距离，然后不断更新就好 在
            current = Math.min(Math.abs(houses[i] - heaters[start]), Math.abs(heaters[end] - houses[i]));
            result = Math.max(result, current);
        }
        return result;
    }

    public static void main(String[] args) {
    	Solution test = new Solution();
    	int[] houses = {1,2,3,4};
    	int[] heaters = {1, 4};
    int result =	 test.findRadius(houses, heaters);
    System.out.println(result);
    }
}
