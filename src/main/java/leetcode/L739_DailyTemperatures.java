package leetcode;

import java.util.Stack;

/**
 * @Description: Given a list of daily temperatures T, return a list such that,
 * for each day in the input, tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
 * <p>
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73],
 * your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * @Auther: kun
 * @Date: 2019-07-22 09:19
 */
public class L739_DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length < 1) {
            return null;
        }
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int i = 1;
        while (i < T.length) {
            if (stack.isEmpty()) {
                stack.push(i++);
                continue;
            }
            int cur = stack.peek();
            if (T[cur] >= T[i]) {
                stack.push(i++);
                continue;
            }
            stack.pop();
            res[cur] = i - cur;
        }

        while (!stack.isEmpty()) {
            res[stack.pop()] = 0;
        }
        return res;
    }

}
