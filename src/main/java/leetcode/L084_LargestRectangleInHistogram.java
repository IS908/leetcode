package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * <p/>
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * <p/>
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * <p/>
 * For example,
 * Given heights = [2,1,5,6,2,3],
 * return 10.
 * <p/>
 * Created by kevin on 2016/3/17.
 */
@Deprecated
public class L084_LargestRectangleInHistogram {
    public int largeestRestangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        return getMax(heights, 0, heights.length);
    }

    private int getMax(int[] heights, int s, int e) {
        if (s + 1 >= e) return heights[s];
        int min = s;
        boolean sorted = true;
        for (int i = s; i < e; i++) {
            if (i > s && heights[i] < heights[i - 1]) sorted = false;
            if (heights[min] > heights[i]) min = i;
        }
        if (sorted) {
            int max = 0;
            for (int i = s; i < e; i++) {
                max = Math.max(max, heights[i] * (e - i));
            }
            return max;
        }
        int left = (min > s) ? getMax(heights, s, min) : 0;
        int right = (min < e - 1) ? getMax(heights, min + 1, e) : 0;
        return Math.max(Math.max(left, right), (e - s) * heights[min]);
    }

    /**
     * C++ 移植过来有问题
     * @param heights
     * @return
     */
    public int largeestRestangleArea01(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int[] h = Arrays.copyOf(heights, heights.length + 1);
        h[heights.length] = heights[0];
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < h.length; ) {
            if (stack.empty() || h[i] > h[stack.peek()]) {
                stack.push(i++);
            } else {
                int tmp = stack.peek();
                stack.pop();
                res = Math.max(res, h[tmp] * (stack.empty() ? i : i - stack.peek() - 1));
            }
        }
        return res;
    }
}
