package DSA.Array.BullsandCows;

/*
 * For example:

Secret number:  "1807"
Friend's guess: "7810"
Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 */
public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                if (count[secret.charAt(i) - '0'] < 0) {
                    cows++;
                }
                if (count[guess.charAt(i) - '0'] > 0) {
                    cows++;
                }
                count[secret.charAt(i) - '0']++;
                count[guess.charAt(i) - '0']--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}