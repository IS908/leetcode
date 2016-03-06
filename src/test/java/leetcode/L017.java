package leetcode;

import org.junit.Test;

import java.util.List;

/**
 * Created by kevin on 2016/3/2.
 */
public class L017 {
    @Test
    public void test() {
        L017_LetterCombinationsOfAPhoneNumber l017 = new L017_LetterCombinationsOfAPhoneNumber();
        String str = "23";
        List<String> res = l017.letterCombinations(str);
        for (String tmp: res) {
            System.out.println(tmp);
        }
    }
}
