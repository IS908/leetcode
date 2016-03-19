package leetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p/>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 * <p/>
 * Created by kevin on 2016/3/19.
 */
public class L122_BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int diff = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) diff += prices[i] - prices[i - 1];
        }
        return diff;
    }
}
