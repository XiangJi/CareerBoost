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
    // BF N^2
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
    //
}
