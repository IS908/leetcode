package leetcode;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p/>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p/>
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * <p/>
 * Created by kevin on 16-3-17.
 */
public class L150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null) return 0;
        String op = "+-*/";
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if (!op.contains(str)) {
                stack.push(Integer.valueOf(str));
            } else {
                int tmp = 0, pos = stack.pop(), pre = stack.pop();
                switch (str) {
                    case "+":
                        tmp = pre + pos;
                        break;
                    case "-":
                        tmp = pre - pos;
                        break;
                    case "*":
                        tmp = pre * pos;
                        break;
                    case "/":
                        tmp = pre / pos;
                        break;
                    default:
                        break;
                }
                stack.push(tmp);
            }
        }
        return stack.pop();
    }
}
