package DSA.DynamicProgramming.LargestSumofAverages;

/*
 * Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. Such a word is said to complete the given string licensePlate

Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.

It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.

The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.

Example 1:
Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
Output: "steps"
Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
Note that the answer is not "step", because the letter "s" must occur in the word twice.
Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
Example 2:
Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
Output: "pest"
Explanation: There are 3 smallest length words that contains the letters "s".
We return the one that occurred first.
Note:
licensePlate will be a string with length in range [1, 7].
licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
words will have a length in the range [10, 1000].
Every words[i] will consist of lowercase letters, and have length in range [1, 15].

N^3 - 1000

Split DP: like LC 139 Word Break, LC 312 Burst Balloons

dp[k][i], max avg sum of first i elements partitioned into k groups

init:
dp[1][i] = avg(1~i)

Function:
dp[k][i] = max(dp[k - 1][j]) + abg(j ~ i))

State Table:
Write it down

Answer: DP[k][n]

T: (kn^2)

rolling array to remove k
 */
class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int[] sum = new int[A.length];
        for (int i = 0; i < A.length; i++)
            sum[i] = A[i] + (i > 0 ? sum[i - 1] : 0);
        double[][] dp = new double[A.length][K + 1];

        for (int groups = 1; groups <= K; groups++) {
            for (int s = 0; s + groups <= A.length; s++) {
                if (groups == 1) {
                    dp[s][groups] = ((double) (sum[A.length - 1] - sum[s] + A[s]) / (A.length - s));
                    continue;
                }
                for (int e = s; e + groups <= A.length; e++) {
                    dp[s][groups] = Math.max(dp[s][groups],
                            (dp[e + 1][groups - 1] + (double) (sum[e] - sum[s] + A[s]) / (e - s + 1)));
                }
            }
        }
        return dp[0][K];
    }

    // Remove K
    public double largestSumOfAveragesII(int[] A, int K) {
        int N = A.length;
        double[] P = new double[N + 1];
        for (int i = 0; i < N; ++i)
            P[i + 1] = P[i] + A[i];

        double[] dp = new double[N];
        for (int i = 0; i < N; ++i)
            dp[i] = (P[N] - P[i]) / (N - i);

        for (int k = 0; k < K - 1; ++k)
            for (int i = 0; i < N; ++i)
                for (int j = i + 1; j < N; ++j)
                    dp[i] = Math.max(dp[i], (P[j] - P[i]) / (j - i) + dp[j]);

        return dp[0];
    }

}