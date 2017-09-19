package DSA.HashTable.NumberofBoomerangs;

import java.util.HashMap;

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