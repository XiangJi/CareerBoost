package DSA.Array.MaximizeDistancetoClosestPerson;

/*
 * Intuition

In a group of K adjacent empty seats between two people, the answer is (K+1) / 2.

Algorithm

For each group of K empty seats between two people, we can take into account the candidate answer (K+1) / 2.

For groups of empty seats between the edge of the row and one other person, the answer is K, and we should take into account those answers too.
 */
public class Solution {
    public int maxDistToClosest(int[] seats) {
        int N = seats.length;
        int K = 0; //current longest group of empty seats
        int ans = 0;

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) {
                K = 0;
            } else {
                K++;
                ans = Math.max(ans, (K + 1) / 2);
            }
        }

        for (int i = 0; i < N; ++i)  if (seats[i] == 1) {
            ans = Math.max(ans, i);
            break;
        }

        for (int i = N-1; i >= 0; --i)  if (seats[i] == 1) {
            ans = Math.max(ans, N - 1 - i);
            break;
        }

        return ans;
    }
}