package DSA.Misc.ShortestCompletingWord;

import java.util.Arrays;
import java.util.Comparator;

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
 * Easy 实现题
 */
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String license = licensePlate.toLowerCase();
        int[] map = new int[26];

        for (char c : license.toCharArray()) {
            if (c - 'a' >= 0 && c - 'a' < 26) {
                map[c - 'a']++;
            }
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        for (int i = 0; i < words.length; i++) {
            if (isMatch(words[i], map))
                return words[i];
        }
        return "";
    }

    private boolean isMatch(String word, int[] map) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] > count[i])
                return false;
        }
        return true;
    }
}