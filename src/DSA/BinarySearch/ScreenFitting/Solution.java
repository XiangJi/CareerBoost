package DSA.BinarySearch.ScreenFitting;

/*
 * 1. 已知screen的高和宽，给你最小和最大的fontSize，要求给定一个string，将string用竟可能大的fontSize显示在screen里。已知两个API getHeight(intfontSize), getWidth(char c, int fontSize)，可以得到每个character在不同fontSize下的高和宽。 来源一亩.三分地论坛.
.

# assume different characters have the same height for the same font
def getLargestFont(s, H, W, smallest, largest):

    small = smallest
    large = largest
    while small <= large:
        mid = small + (large - small) // 2
        if canFit(s, mid, H, W):
            small = mid + 1.
        else:
            large = mid - 1

    if large < smallest:
        return -1    # even the smallest number cannot fit
    else:
        return large

def canFit(s, font, H, W):
    curH = H. from: 1point3acres
    curW = W
    length = len(s)
    i = 0
    while i < length:
        if getHeight(s, font) < curH and getWidth(s, font) < cur
            curW -= getWidth(c.font)
            i += 1
        elif getHeight(s, font) < curH and getWidth(s, font) > curW:   # need to restart with a new line.
            curH = H - curH
            curW = W
        else:
            return False

    return True

 */
public class Solution {

}
