package DSA.Math.RectangleArea;

/*
 * Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.

 */
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int box1= (C - A) * (D - B);
        int box2 = (G - E) * (H - F);

        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);

        int overlap = 0;
        //算法是扫完四边看条件
        if (left < right && top > bottom) {
            overlap = (right - left) * (top - bottom);
        }

        return box1 + box2 - overlap;
    }
}