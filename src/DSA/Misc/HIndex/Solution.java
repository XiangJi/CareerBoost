package DSA.Misc.HIndex;

import java.util.Arrays;

/*
 * "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

画图 x：paper y citations
问题就是找sort之后图中的最大方块
两种方法来排序 比较排序和counting sort
1. Sort
After sorting, if citations[i] > i, paper 0 ~ i all has at least  i + 1 citations 
 */
public class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0 || citations == null) {
            return 0;
        }
        Arrays.sort(citations);
        int i = 0;
        // since default sort is ascending, so from the graph, we scan from the back
        while (i < citations.length && citations[citations.length - i - 1] > i) {
            i++;
        }
        return i;
    }
}
