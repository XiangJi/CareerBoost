package DSA.DFS.ExpressionAddOperators;

import java.util.ArrayList;
import java.util.List;
/*
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
 */
//version: 高频题班
public class Solution {
 /**
  * @param num a string contains only digits 0-9
  * @param target an integer
  * @return return all possibilities
  */
 String num;
 int target;
 List<String> ans = new ArrayList<>();

 void dfs(int pos, String str, long sum, long lastF) {
     if (pos == num.length()) {
         if (sum == target) {
             ans.add(str);
         }
         return;
     }
     for (int i = pos; i < num.length(); i++) {
         long cur = Long.parseLong(num.substring(pos, i + 1));

         if (pos == 0) {
             dfs(i + 1, "" + cur, cur, cur);
         } else {
             dfs(i + 1, str + "*" + cur, sum - lastF + lastF * cur, lastF * cur);
             dfs(i + 1, str + "+" + cur, sum + cur, cur);
             dfs(i + 1, str + "-" + cur, sum - cur, -cur);
         }
         if (num.charAt(pos) == '0') {
             break;
         }
     }
 }

 public List<String> addOperators(String num, int target) {
     // Write your code here
     this.num = num;
     this.target = target;
     dfs(0, "", 0, 0);
     return ans;
 }
}