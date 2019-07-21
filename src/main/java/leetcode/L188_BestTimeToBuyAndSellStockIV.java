package leetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p/>
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * <p/>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * <p/>
 * Created by kevin on 2016/3/19.
 */
public class L188_BestTimeToBuyAndSellStockIV {

    // TODO
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        if (k < 1) {
            return 0;
        }
        // 当k大于数据的一半长度时肯定买卖不到k次，此时计算最大收益
        if (k > prices.length / 2) {
            int max = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                int diff = prices[i + 1] - prices[i];
                max += diff > 0 ? diff : 0;
            }
            return max;
        }

        // 当k小于数组长度的一半时，按买卖k次计算
        int[] buy = new int[k];
        int[] sell = new int[k];
        for (int i = 0; i < k; i++) {
            buy[i] = sell[0] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < prices.length; i++) {
            buy[0] = Math.max(buy[0], -prices[i]);
            sell[0] = Math.max(sell[0], prices[i] + buy[0]);
            for (int j = 1; j < k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], prices[i] + buy[j]);
            }
        }
        return sell[k - 1];
        /*if (k <= 0 || prices == null || prices.length <= 0) return 0;
        if (k > prices.length / 2) { // in this case, it's the same problem as Best Time to Buy & Sell Stock II
            int max = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                int diff = prices[i + 1] - prices[i];
                max += diff>0 ? diff : 0;
            }
            return max;
        } else {
            int [] buy = new int[k];
            int [] sell = new int[k];

            Arrays.fill(buy, Integer.MIN_VALUE);

            for (int price: prices) {
                int tmp = 0;
                for (int i = 0; i < k; i ++) {
                    int buffer = 0;                          // used to avoid duplicate calculation
                    buffer = tmp - price;
                    if (buy[i] < buffer) buy[i] = buffer;

                    buffer = buy[i] + price;
                    if (sell[i] < buffer) sell[i] = buffer;
                    tmp = sell[i];
                }
            }
            return sell[k - 1];
        }*/
    }
}
