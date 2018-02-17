package DSA.TwoPointers.ContainerWithMostWater;
/*
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

 */
public class Solution {
    
    public int maxArea(int[] height) {
        if (height.length == 0 || height == null) {
            return 0;
        }
        int size = height.length;
        int i = 0;
        int j = size - 1;
        
        int h = 0;
        int w = 0;
        
        int maxWater = -1;
        
        while (i < j) {
            h = height[i] < height[j] ? height[i] : height[j];
            w = j - i;
            maxWater = maxWater < (h * w) ? (h * w) : maxWater;
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxWater;
        
    }
}