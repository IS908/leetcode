package leetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p/>
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * <p/>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * <p/>
 * Created by kevin on 2016/3/19.
 */
public class L123_BestTimeToBuyAndSellStockIII {
    // TODO
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int buy1 = prices[0], buy2 = Integer.MIN_VALUE,
                sell1 = Integer.MIN_VALUE, sell2 = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            // 一些列联动效应
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, prices[i] + buy2);
        }
        return sell2;
    }
}
