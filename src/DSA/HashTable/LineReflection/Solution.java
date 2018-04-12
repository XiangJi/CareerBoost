package DSA.HashTable.LineReflection;

import java.util.HashSet;

/*
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

Example 1:
Given points = [[1,1],[-1,1]], return true.

Example 2:
Given points = [[1,1],[-1,-1]], return false.

Follow up:
Could you do better than O(n^2)? BF（找每个点有没有对应点）

题意理解
 x1 + x2 = c
     min max
     x1 = c - x2
     平行于y轴 : x : 对称 (两个点)
                y : 相同
     HashSet
     1, 找出关于哪个轴对称
     2, check

 */
public class Solution {
    public boolean isReflected(int[][] points) {
        HashSet<String> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] pair : points) {
            set.add(pair[0] + "," + pair[1]);
            min = Math.min(min, pair[0]);
            max = Math.max(max, pair[0]);
        }
        int sum = min + max;
        for (int[] pair : points) {
            if (!set.contains(sum - pair[0] + "," + pair[1])) {
                return false;
            }
        }
        return true;
    }
}
