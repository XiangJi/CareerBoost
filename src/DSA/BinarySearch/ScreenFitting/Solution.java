package DSA.BinarySearch.ScreenFitting;

/*
 * 1. 已知screen的高和宽，给你最小和最大的fontSize，要求给定一个string，将string用竟可能大的fontSize显示在screen里。已知两个API getHeight(intfontSize), getWidth(char c, int fontSize)，可以得到每个character在不同fontSize下的高和宽。 来源一亩.三分地论坛.
.

# assume different characters have the same height for the same font


 */
public class Solution {
    public int getLargestFont(String s, int H, int W, int smallest, int largest) {

        int l = smallest;
        int r = largest;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canFit(s, mid, H, W)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if (r < smallest) {
            return -1; // even the smallest number cannot fit;
        } else {
            return r;
        }
    }

    public boolean canFit(String s, int font, int H, int W) {
        int curH = H;
        int curW = W;
        int length = s.length();
        int i = 0;
        while (i < length) {
            if (getHeight(s.charAt(i), font) < curH && getWidth(s.charAt(i), font) < curW) {
                curW -= getWidth(s.charAt(i), font);
                i += 1;
            } else if (getHeight(s.charAt(i), font) < curH && getWidth(s.charAt(i), font) > curW) {
                // need to restart with a new line.
                curH = H - curH;
                curW = W; // reset curW
            } else {
                return false;
            }
        }
        return true;
    }

    private int getHeight(char a, int font) {
        return 2;
    }

    private int getWidth(char a, int font) {
        return 2;
    }

}
