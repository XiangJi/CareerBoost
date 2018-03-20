package DSA.Misc.HIndex;

import java.util.Arrays;

/*
 * "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

画图 x：paper y citations
问题就是找sort之后图中的最大方块
两种方法来排序 比较排序和counting sort
1. Compare sort
After sorting, if citations[i] > i, paper 0 ~ i all has at least  i + 1 citations

2. Counting sort
The most commonly used non-comparison sorting is counting sort
Any citation larger than nn can be replaced by nn and the hh-index will not change after the replacement
The reason is that hh-index is upper bounded by total number of papers
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

    // Counting sort
    public int hIndexII(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
        // counting papers for each citation number
        for (int c: citations)
            papers[Math.min(n, c)]++;
        // Now, we have the count number of papers for each citation number
        // finding the h-index

        int k = n;
        // s means sum from the right
        // the first k from right to left that has k<= s is the index
        for (int s = papers[n]; k > s; s += papers[k])
            k--;
        return k;
    }
}
