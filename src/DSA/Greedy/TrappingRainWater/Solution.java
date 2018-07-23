package DSA.Greedy.TrappingRainWater;

/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 * Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

神奇神奇
 */
public class Solution {
    // DP 存left 高 right 高 然后取min -自己高就是每个位置的高度
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int ans = 0;
        int size = height.length;
        int[] left_max = new int[size],
                right_max = new int[size];
        // init
        left_max[0] = height[0];
        for (int i = 1; i < size; i++) {
            left_max[i] = Math.max(height[i],
                    left_max[i - 1]);
        }
        // init
        right_max[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            right_max[i] = Math.max(height[i],
                    right_max[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(left_max[i], right_max[i])
                    - height[i];
        }
        return ans;
    }

    // 优化 双指针
}
