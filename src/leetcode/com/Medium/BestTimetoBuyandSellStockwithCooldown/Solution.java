package leetcode.com.Medium.BestTimetoBuyandSellStockwithCooldown;

public class Solution {

    public static int maxProfit(int[] prices) {
        int sell = 0;
        int hold = Integer.MIN_VALUE;
        int prev = 0;

        for (final int prince : prices) {
            final int cache = sell;
            sell = Math.max(sell, hold + prince);
            hold = Math.max(hold, prev - prince);
            prev = cache;
        }
        return sell;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));//Output: 3
    }
}
