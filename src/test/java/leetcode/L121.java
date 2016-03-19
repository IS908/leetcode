package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/3/19.
 */
public class L121 {
    @Test
    public void test() {
        L121_BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new L121_BestTimeToBuyAndSellStock();
        int[] prices = {3, 2, 1, 4, 5, 4, 7, 5, 3, 1};
        int res = bestTimeToBuyAndSellStock.maxProfit(prices);
        System.out.println(res);
    }
}
