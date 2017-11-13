package DSA.Array.FindtheCelebrity;

/* The knows API is defined in the parent class Relation.
boolean knows(int a, int b); */

public class Solution extends Relation {
    /**
     * @param n
     *            a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        // Logic, exclude one by one
        int candidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        // Since may not be exsiting, validate the result

        for (int i = 0; i < n; i++) {
            if (candidate != i && knows(candidate, i)) {
                return -1;
            }

            if (candidate != i && !knows(i, candidate)) {
                return -1;
            }
        }

        return candidate;
    }
}