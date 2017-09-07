package DSA.BinarySearch.Heaters;

import java.util.Arrays;

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
