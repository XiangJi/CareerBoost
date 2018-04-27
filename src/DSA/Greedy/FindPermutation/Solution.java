package DSA.Greedy.FindPermutation;
/*
 * By now, you are given a secret signature consisting of character 'D' and 'I'. 'D' represents a decreasing relationship between two numbers, 'I' represents an increasing relationship between two numbers. And our secret signature was constructed by a special integer array, which contains uniquely all the different number from 1 to n (n is the length of the secret signature plus 1). For example, the secret signature "DI" can be constructed by array [2,1,3] or [3,1,2], but won't be constructed by array [3,2,4] or [2,1,3,4], which are both illegal constructing special string that can't represent the "DI" secret signature.

On the other hand, now your job is to find the lexicographically smallest permutation of [1, 2, ... n] could refer to the given secret signature in the input.

Example 1:
Input: "I"
Output: [1,2]
Explanation: [1,2] is the only legal initial spectial string can construct secret signature "I", where the number 1 and 2 construct an increasing relationship.
Example 2:
Input: "DI"
Output: [2,1,3]
Explanation: Both [2,1,3] and [3,1,2] can construct the secret signature "DI", 
but since we want to find the one with the smallest lexicographical permutation, you need to output [2,1,3]
Note:

The input string will only contain the character 'D' and 'I'.
The length of input string is a positive integer and will not exceed 10,000

这题用贪婪算法最为简单，我们来看一个例子：

D D I I D I

1 2 3 4 5 6 7

3 2 1 4 6 5 7

我们不难看出，只有D对应的位置附近的数字才需要变换，而且变换方法就是倒置一下字符串，
我们要做的就是通过D的位置来确定需要倒置的子字符串的起始位置和长度即可。通过观察，我们需要记录D的起始位置i，
还有D的连续个数k，那么我们只需要在数组中倒置[i, i+k]之间的数字即可


 */
class Solution {
    public int[] findPermutation(String s) {
        int[] permute = new int[s.length() + 1];
        for (int i = 0; i < permute.length; i++) {
            permute[i] = i + 1;
        }
        int left = 0; 
        while (left < permute.length - 1) {
            if (s.charAt(left) != 'D') { left++; continue; }
            int right = left + 1;
            while (right < permute.length - 1 && s.charAt(right) == 'D') {
                right++;
            }
            reverse(permute, left, right);
            left = right + 1;
        }
        return permute;  
    }
    
    private void reverse(int[] permute, int left, int right) {
        while (left < right) {
            int temp = permute[left];
            permute[left] = permute[right];
            permute[right] = temp;
            left++;
            right--;
        }
    }
}
