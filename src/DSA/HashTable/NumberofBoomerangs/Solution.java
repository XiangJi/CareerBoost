package DSA.HashTable.NumberofBoomerangs;

import java.util.HashMap;

/*
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the 
 * distance between i and j equals the distance 
 * between i and k (the order of the tuple matters).
 * 
 * 现在给了我们n个点，让我们找出回旋镖的个数。那么我们想，如果我们有一个点a，还有两个点b和c，如果ab和ac之间的距离相等，
 * 那么就有两种排列方法abc和acb；如果有三个点b，c，d都分别和a之间的距离相等，那么有六种排列方法，abc, acb, acd, adc, abd, adb，那么是怎
 * 么算出来的呢，很简单，如果有n个点和a距离相等，那么排列方式为n(n-1)，这属于最简单的排列组合问题了，我大天朝中学生都会做的。那么我们问题就变成了遍历
 * 所有点，让每个点都做一次点a，然后遍历其他所有点，统计和a距离相等的点有多少个，然后分别带入n(n-1)计算结果并累加到res中，只有当n大于等于2时，res值才会真正增加
 * 
 */
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // put distance and occurrence
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int dist = getDistance(points[i], points[j]);
                if (!map.containsKey(dist)) {
                    map.put(dist, 1);
                } else {
                    map.put(dist, map.get(dist) + 1);
                }
            }
            for (int value : map.values()) {
                if (value == 1) {
                    continue;
                }
                result += (value - 1 + 1) * (value - 1) / 2 * 2;
            }

        }
        return result;
    }

    private int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        // not necessary to get square
        return dx * dx + dy * dy;
    }
}