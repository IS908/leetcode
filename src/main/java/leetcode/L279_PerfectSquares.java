package leetcode;

import java.util.Arrays;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p>
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 * <p>
 * 四平方和定理 @link http://www.cnblogs.com/grandyang/p/4800552.html
 * <p>
 * Created by kevin on 16-9-5.
 */
public class L279_PerfectSquares {
    public int numSquares(int n) {
        while (n % 4 == 0) n /= 4;
        if (n % 8 == 7) return 4;
        for (int a = 0; a * a <= n; ++a) {
            int b = (int) Math.sqrt(n - a * a);
            if (a * a + b * b == n) {
                return (a != 0 && b != 0) ? 2 : 1;
            }
        }
        return 3;
    }

    public int numSquares02(int n) {
        while (n % 4 == 0) n /= 4;
        if (n % 8 == 7) return 4;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
            }
        }
        return dp[n];
    }
}
