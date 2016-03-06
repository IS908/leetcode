package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/2/26.
 */
public class L010 {

    @Test
    public void test() {
        L010_RegularExpressionMatching l010 = new L010_RegularExpressionMatching();
        System.out.println(l010.isMatch("aab", "c*a*b"));
    }
}
