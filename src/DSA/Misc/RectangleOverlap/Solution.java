package DSA.Misc.RectangleOverlap;

public class Solution {
    /*
     * @param l1: top-left coordinate of first rectangle
     * @param r1: bottom-right coordinate of first rectangle
     * @param l2: top-left coordinate of second rectangle
     * @param r2: bottom-right coordinate of second rectangle
     * @return: true if they are overlap or false
     */
    public boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        // if not overplap, top bottom or left right
        if (r1.y > l2.y || r2.y > l1.y) {
            return false;
        }
        if (r1.x < l2.x || r2.x < l1.x) {
            return false;
        }
        return true;
    }
}