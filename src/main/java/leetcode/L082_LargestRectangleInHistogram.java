package leetcode;

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
public class L082_LargestRectangleInHistogram {
    public int largeestRestangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(heights[0]);
        int cur = heights[0];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < heights.length; i++) {
            while (heights[i] >= cur) {
                stack.push(heights[i++]);

            }
            while (!stack.empty()) {

            }
        }
        return 0;
    }
}
