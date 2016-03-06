package leetcode;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p/>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p/>
 * Created by kevin on 2016/3/6.
 */
public class L070_ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 2) return 1;
        int one = 1, two = 1, three = 2;
        for (int i = 1; i < n; i++) {
            three = one + two;
            one = two;
            two = three;
        }
        return three;
    }
}
