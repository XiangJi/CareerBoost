package DSA.DFS.StrobogrammaticNumberII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].

BF: N ^ N ^ N 按第一题的方法遍历 然后双指针判断

Optimization:
DFS： N ^ N
数学找规律
 */
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return dfs(n, n);
    }
    // also can use return void, put List<String> in the args
    // m is the constant length
    // n is the recursive tmp length
    public List<String> dfs(int n, int m) {
        if (n == 0) {
            return new ArrayList<String>(Arrays.asList(""));
        }
        if (n == 1) {
            return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        }
        List<String> tmp = dfs(n - 2, m);
        List<String> result = new ArrayList<>();

        for (int i = 0; i < tmp.size(); i++) {
            String s = tmp.get(i);
            if (n != m) {
                result.add("0" + s + "0");
            }
            result.add("1" + s + "1");
            result.add("6" + s + "9");
            result.add("8" + s + "8");
            result.add("9" + s + "6");
        }
        return result;
    }
}