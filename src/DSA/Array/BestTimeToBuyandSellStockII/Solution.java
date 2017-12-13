package DSA.Array.BestTimeToBuyandSellStockII;

//ie, buy one and sell one share of the stock multiple times
public class Solution {
 public int maxProfit(int[] prices) {
     // buy each increasing segment
     if (prices == null || prices.length <= 1) {
         return 0;
     }
     
     int maxProfit = 0;
     
     for (int i = 1; i < prices.length; i++) {
         if (prices[i] - prices[i - 1] > 0) {
             maxProfit += prices[i] - prices[i - 1];
         }
     }
     return maxProfit;
 }
}