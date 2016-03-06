package leetcode;

import java.util.Stack;

/**
 * 细节处理
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p/>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * <p/>
 * Created by kevin on 2016/3/2.
 */
public class L020_ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    if (stack.pop() != '(') return false;
                } else {
                    return false;
                }
            } else if (ch == ']') {
                if (!stack.isEmpty()) {
                    if (stack.pop() != '[') return false;
                } else {
                    return false;
                }
            } else if (ch == '}') {
                if (!stack.isEmpty()) {
                    if (stack.pop() != '{') return false;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
