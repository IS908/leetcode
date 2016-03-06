package leetcode;

import org.junit.Test;

import java.util.Random;

/**
 * Created by kevin on 2016/1/10.
 */
public class L326 {
    @Test
    public void isPowerOfThree() {
        L326_PowerOfThree powerOfThree = new L326_PowerOfThree();
        int num = new Random().nextInt();
        boolean flag = powerOfThree.isPowerOfThree(num);
        System.out.println(num + ":" + flag);
    }
}
