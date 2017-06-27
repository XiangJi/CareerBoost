package DSA.BinarySearch.GuessNumberHigherorLower;
/* The guess API is defined in the parent class GuessGame.
@param num, your guess
@return -1 if my number is lower, 1 if my number is higher, otherwise return 0
   int guess(int num); */


public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if (n < 1) {
            return -1;
        }
        int start = 1;
        int end = n;
        int mid;
        while (start + 1 < end) {
            mid = start + (end -start) / 2;
            if (guess(mid) == 1) {
                start = mid;
            } else if (guess(mid) == -1) {
                end = mid;
            } else {
                return mid;
            }
        }
        if (guess(start) == 0) {
            return start;
        } else {
            return end;
        }
    }

    private int guess(int n) {
        int fake = 86;
        if (n > fake) {
            return -1;
        } else if (n < fake) {
            return 1;
        }

        return 0;
    }
}