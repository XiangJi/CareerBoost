package DSA.Heap.SuperUglyNumber;

import java.util.PriorityQueue;

/*
 * Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12
 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
(4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer.

first k, so use heap
小链表问题
T: nlogk S: O(K)

1 * 2 7 13 19
2 * 2 7 13 19
4 * 2 7 13 19
result 1 2
next 2/1/2
offer 2 * prev 2 =4 ; 2, 2
 */
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        res[0] = 1;

        PriorityQueue<Num> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        // initialization pq, 2, 1, 2; 7 ,1, 7
        for (int i = 0; i < primes.length; i++) {
            pq.offer(new Num(primes[i], 1, primes[i]));
        }

        // implementation
        for (int i = 1; i < n; i++) {
            res[i] = pq.peek().val;
            while (pq.peek().val == res[i]) {
                Num next = pq.poll();
                pq.offer(new Num(next.prime * res[next.index], next.index + 1, next.prime));
            }
        }

        return res[n - 1];
    }

    class Num {
        int val;
        int index;
        int prime;

        public Num(int val, int index, int prime) {
            this.val = val;
            this.index = index;
            this.prime = prime;
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] primes = {2, 7, 13, 19};
        test.nthSuperUglyNumber(4, primes);
    }
}