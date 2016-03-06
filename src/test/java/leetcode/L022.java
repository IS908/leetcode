package leetcode;

import org.junit.Test;

import java.util.List;

/**
 * Created by kevin on 2016/3/3.
 */
public class L022 {
    @Test
    public void test() {
        L022_GenerateParentheses l022 = new L022_GenerateParentheses();
        List<String> list = l022.generateParenthesis(3);
        for (String tmp: list) {
            System.out.println(tmp);
        }
    }
}
