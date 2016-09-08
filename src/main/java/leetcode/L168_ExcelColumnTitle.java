package leetcode;

import java.util.Stack;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p/>
 * For example:
 * <p/>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * Credits:
 * Special thanks to @ifanchu for adding this problem and creating all test cases.
 * <p/>
 * Created by kevin on 2016/3/7.
 */
public class L168_ExcelColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        convert(n - 1, sb);
        return sb.toString();
    }

    public void convert(int n, StringBuilder sb) {
        if (n > 25) convert(n / 26 - 1, sb);
        sb.append((char) ('A' + (n % 26)));
    }

    public String convertToTitle02(int n) {
        Stack<Character> stack = new Stack<>();
        n--;
        while (n > 25) {
            stack.push((char) ('A' + (n % 26)));
            n = n / 26 - 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((char) ('A' + n));
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
