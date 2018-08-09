package DSA.HashTable.BullsandCows;

/*
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows.

Please note that both secret number and friend's guess may contain duplicate digits.

Example 1:

Input: secret = "1807", guess = "7810"

Output: "1A3B"

Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
Example 2:

Input: secret = "1123", guess = "0111"

Output: "1A1B"

Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.

The idea is to iterate over the numbers in secret and in guess and count
all bulls right away. For cows maintain an array that stores count of th
e number appearances in secret and in guess. Increment cows when either n
umber from secret was already seen in guest or vice versa.


Follow up:
猜数字题目我觉得应该是要求双人博弈的最大收益。
类似于AI入门的黑白棋问题，给个残局，问最多能赢对方多少子 —— 假设是对方每一步都会使用最优策略。
. 一亩-三分-地，独家发布
也就是说，猜数字双方的行动构成了一颗博弈树，奇数层是你的行动：选1111-9999中的一个数字，偶数层是对方的行动：回答xAyB（共15种可能，但是几步之后会受已有回答的限制而减少可能性）。

你的目标是最小化到达4A0B节点的步数，而对手的目标是最大化此步数。 来源一亩.三分地论坛.
而题目所问的“最少多少次能猜着”的意思就是“在对手总是采取最优策略时，到达4A0B节点的步数最小是多少？”

注意这里强调对手使用最优策略是必要的，否则我们假设对手一上来回答个"4A0B"，最少一步搞定，这题目就没有意义了。

那么解法就是minimax算法，再加上alpha-beta剪枝。

此外数字以及xAyB的表示（encoding）可能有优化空间，这里就不展开了..

考点 需要1Pass
用count hash存储
如果正负号
secret 出现过就++ 如果<0 cows++ vice versa

用一个count数组 hash

一个永远++另一个--
 */
public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
                if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }

}
