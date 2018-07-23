package DSA.Array.HIndexII;

/*
 * A scientist has index h if h of his/her N papers have at least h citations each, 
 * and the other N − h papers have no more than h citations each."
 * 
 * 
 */
/*
 * 
 * [1,2,4,5,7,8] => 4
 * [1,2,3,3,3] => 3
 */
public class Solution {
    public int hIndex(int[] citations) {
        int l = citations.length;
        int start = 0;
        int end = citations.length - 1;
        
        // just start <= end
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (citations[mid] == l - mid) {
                return l - mid;
             // 如果该点是有效的H指数，则最大H指数一定在右边
            } else if (citations[mid] < l - mid){
                start = mid + 1;
             // 否则最大H指数在左边
            } else {
                end = mid - 1;
            }
        }
        return l - start;
    }
}