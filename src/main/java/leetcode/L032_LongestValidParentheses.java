package leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p/>
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * <p/>
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * <p/>
 * Created by kevin on 2016/3/16.
 */
@Deprecated
public class L032_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int res = 0;
        int tep = 0;
        Stack<Integer> s1 = new Stack<>();
        int data[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') s1.push(i);
            else {
                if (!s1.empty()) {
                    data[i] = 1;
                    data[s1.pop()] = 1;
                }
            }
        }
        for (int i : data) {
            if (i == 1) tep++;
            else {
                res = Math.max(tep, res);
                tep = 0;
            }
        }
        return Math.max(tep, res);
    }
}
