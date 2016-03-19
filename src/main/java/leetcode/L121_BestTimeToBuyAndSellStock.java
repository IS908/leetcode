package leetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p/>
 * If you were only permitted to complete at most one transaction
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p/>
 * Created by kevin on 2016/3/19.
 */
public class L121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int min = prices[0], diff = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            diff = Math.max(diff, prices[i] - min);
        }
        return diff;
    }
}
