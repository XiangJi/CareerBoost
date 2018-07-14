package DSA.BST.TheSkylineProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
/*
 * 基础问题是sweep line with start end time intervals count number of flights in the sky
 */
class Solution {
    /** Sweep line 画出天际线 
     * 用线去扫描：起点：最高点 终点：第二高 
     * time : O(nlogn)
     * space : O(n)
     * @param buildings
     * @return
     */

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        // construct sweep line result
        List<int[]> heights = new ArrayList<>();
        for (int[] b: buildings) {
            heights.add(new int[]{b[0], - b[2]}); // 起始和终止区分 后面根据x 拍排序
            heights.add(new int[]{b[1], b[2]});
        }
        Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]); // 不等的话直接按x排序 不然按高度排序
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        map.put(0,1);
        int prev = 0;

        for (int[] h: heights) {
            if (h[1] < 0) {
                map.put(-h[1], map.getOrDefault(-h[1], 0) + 1);
            } else {
                int cnt = map.get(h[1]);
                if (cnt == 1) {
                    map.remove(h[1]);
                } else {
                    map.put(h[1], cnt - 1);
                }
            }
            int cur = map.firstKey();
            if (prev != cur) {
                res.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return res;
    }
}