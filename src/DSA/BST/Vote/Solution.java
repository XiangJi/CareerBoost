package DSA.BST.Vote;

import java.util.List;

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
TOP K 就是O(N + NlogK) ，扫一遍统计，然后用priority queue得到 top k.
给时间求top k就是先按时间排序票， 然后边扫边求当前的人是不是top k，是就加入到结果集。可能有好几个时间，所以最终返回是一个list，O(NlogN + NlogK)

Heap Google SDET question
用TreeMap yes

For the first question, just travers the vote list and if vote.T <= T increment
the vote for person vote.Name. While doing that maximize the vote number.
(O(n*l) time, O(c*l) space, c is the number of candidates, l is average length of name)

follow-up 1: instead of maximizing one, keep the hashtable with votes[person] = no. votes
now, put that into a vector and find the k-th element (using e.g. quicksort's partion
method which is linear)
(O(n*l) time, O(c*l) space)

follow-up 2: I assume given are the top K candidates at a certain time T I have to find.
I have to keep all candidates sorted at each step and compare the top k of them with
the given list. The first part (keeping candidates sorted at each step) can be done
using a balanced binary-tree, so I have O(n*lg(n)+n*l) for creating and maintaining that tree.
(I will have to transpose the name into an integer, and have a nameId instead of the
string in the tree)
Then I would have k compare's per iteration, which is then O(k*n*lg(n)+n*l). the factor k
I can get rid of if I implement the tree in a way, so I monitor when elements enter and
leave the top k. If one of the desired candidates enters top k, I reduce the amount of
candidates I need in top k, if one leaves, I increment back. If that counter (which
starts with k) is 0 I'm done, I found the first time where the desired condition happend.

 */
public class Solution {
    public class Vote {
        int time;
        String name;
        public Vote(int time, String name) {
            this.time = time;
            this.name = name;
        }
    }
    public String findWinner(List<Vote> votes, int time) {
        String candidate = "";
        
        return candidate;
    }
}
