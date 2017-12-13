package DSA.Array.BestTimeToBuyandSellStock;

// one transction allowed
//buy one and sell one share of the stock, clarify question.
public class Solution {
 public int maxProfit(int[] prices) {
     if (prices == null || prices.length <= 1) {
         return 0;
     }
     
     int maxProfit = 0;
     int low = Integer.MAX_VALUE;
     for (int i = 0; i < prices.length; i++) {
         low = Math.min(low, prices[i]);
         maxProfit = Math.max(maxProfit, prices[i] - low);
     }
     return maxProfit;
 }
 
 public static void main(String[] args) {
     Solution instance = new Solution();
     int[] prices = {1,2,3,4,5};
     System.out.print(instance.maxProfit(prices));
 }
 
 
}