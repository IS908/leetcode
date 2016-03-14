package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/3/14.
 */
public class L028 {
    @Test
    public void test() {
        String str01 = "aaabbababbabbbabaaabbaabbabababbbaaaaaaababbabaababaabbbbaaabbbabb";
        String str02 = "abbabbbabaa";
        L028_ImplementStrStr implementStrStr = new L028_ImplementStrStr();
        int index = implementStrStr.strStr01(str01, str02);
        System.out.println(index);
    }
}
