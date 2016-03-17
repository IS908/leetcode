package leetcode;

/**
 * Given an integer, write a function to determine if it is a power of three.
 * <p/>
 * Follow up:
 * Could you do it without using any loop / recursion?
 * <p/>
 * Credits:
 * Special thanks to @dietpepsi for adding this problem and creating all test cases.
 * <p/>
 * Created by kevin on 2016/1/10.
 */
@Deprecated
public class L326_PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        return Math.abs(Math.pow(3, Math.round(Math.log(n) / Math.log(3))) - n) < 0.01;
    }
}
