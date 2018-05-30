package DSA.Misc.Vote;
/*
 * 面经选举题
 * 给一堆选票，每张选票有候选人和一个时间错，选票并没有排序，然后写个函数返回给定时间点的winner（问了不是多次频繁调用）
 *
 *输入是一个Vote的lisit，Vote是（time，name），和一个时间time；
输出time之前票数最高的人。
follow up1：
输入增加一项：k
输出time之前票数top k 的人
follow up2：
输入：Vote的list和candidate的List（List<String>)
输出当candidate是top n时的最后时间；n = candidate.size()
 *
 *TOP1 就是 O(n)，扫一遍统计每个人的票数，再扫一遍票数求得max
TOP K 就是O(N + NlogK) ，扫一遍统计，然后用priority queue得到 top k. Waral 博客有更多文章,
给时间求top k就是先按时间排序票， 然后边扫边求当前的人是不是top k，是就加入到结果集。可能有好几个时间，所以最终返回是一个list，O(NlogN + NlogK)

用TreeMap?
 */
public class Solution {

}
