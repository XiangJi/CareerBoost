package DSA.Array.RangeAddition;

/*
 * Given:

    length = 5,
    updates = [
        [1,  3,  2],
        [2,  4,  3],
        [0,  2, -2]
    ]

Output:

    [-2, 0, 3, 5, 3]
 */
public class Solution {
    // BF O(N*K)
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int inc = updates[i][2];
            for (int j = start; j <= end; j++) {
                result[j] += inc;
            }
        }
        return result;
    }

    // Optimization O(n + K) 记住解法, 不常见
    public int[] getModifiedArrayII(int length, int[][] updates) {
        int[] result = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int inc = updates[i][2];
            result[start] += inc;

            // 设置一个终止符
            if (end + 1 < length) {
                result[end + 1] -= inc;
            }
        }

        for (int i = 1; i < length; i++) {
            result[i] += result[i - 1];
        }

        return result;
    }
}
