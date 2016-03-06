package leetcode;

/**
 * Created by kevin on 2016/1/10.
 */
public class L326_PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if(n<1) return false;
        return Math.abs(Math.pow(3, Math.round(Math.log(n) / Math.log(3))) - n) < 0.01;
    }
}
