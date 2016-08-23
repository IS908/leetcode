package leetcode;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p/>
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * <p/>
 * Created by kevin on 2016/3/6.
 */
// TODO: 16-8-22
public class L042_TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int water = 0, maxLoc = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[maxLoc]) maxLoc = i;     // 找到最高的那个柱子
        }

        int peek = 0;
        for (int i = 0; i < maxLoc; i++) {                  // 最高柱子左边累加计算
            if (height[i] > peek) peek = height[i];
            water += peek - height[i];
        }
        peek = 0;
        for (int i = height.length - 1; i > maxLoc; i--) {  // 最高柱子右边累加计算
            if (height[i] > peek) peek = height[i];
            water += peek - height[i];
        }
        return water;
    }

    public int trap01(int[] height) {
        if (height == null || height.length < 1) return 0;
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        rightMax[len - 1] = height[len - 1];

        // 从左往右扫一遍，对每个柱子求左边最大值
        // 从右往左扫一遍，对每个柱子求右边最大值
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
            rightMax[len - 1 - i] = Math.max(rightMax[len - i], height[len - i]);
        }

        // 在扫描一边把每个柱子的面积累加
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int cur = Math.min(leftMax[i], rightMax[i]);
            if (cur > height[i]) sum += cur - height[i];    // 此处加判断防止减掉最高的柱子，导致结果变小
        }

        return sum;
    }
}
