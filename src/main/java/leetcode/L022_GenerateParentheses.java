package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p/>
 * For example, given n = 3, a solution set is:
 * <p/>
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * <p/>
 * Created by kevin on 2016/3/2.
 */
@Deprecated
public class L022_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0) {
            return res;
        }
        helper(res, "", n, n);
        return res;
    }

    /**
     * 递归调用解决问题
     * @param res
     * @param present
     * @param left
     * @param right
     */
    private void helper(List<String> res, String present, int left, int right) {
        if (right == 0) {
            res.add(present);
        }
        if (left > 0) {
            helper(res, present + "(", left - 1, right);
        }
        if (right > left) {
            helper(res, present + ")", left, right - 1);
        }
    }

    /**
     *
     * @param result
     * @param list
     * @param left
     * @param right
     * @param n
     */
    private void helper(List<List<Character>> result, List<Character> list, int left, int right, int n) {
        if (right > left) {
            return;
        }
        if (right == n && left == n) {
            List<Character> tmp = new ArrayList<>();
            tmp.addAll(list);
            result.add(tmp);
        }
        if (left < n) {
            list.add('(');
            helper(result, list, left + 1, right, n);
            list.remove(list.size() - 1);
        }
        if (right < n) {
            list.add(')');
            helper(result, list, left, right + 1, n);
            list.remove(list.size() - 1);
        }

    }
}
