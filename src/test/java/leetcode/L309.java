package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/3/21.
 */
public class L309 {
    @Test
    public void test() {
        L309_BestTimeToBuyAndSellStockWithCooldown bestTimeToBuyAndSellStockWithCooldown = new L309_BestTimeToBuyAndSellStockWithCooldown();
        int[] prices = {3, 2, 1, 4, 5, 4, 7, 5, 3, 1};
        int res = bestTimeToBuyAndSellStockWithCooldown.maxProfit(prices);
        System.out.println(res);
    }
}
