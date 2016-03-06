package leetcode;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p/>
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * <p/>
 * Created by kevin on 2016/3/6.
 */
public class L042_TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int water = 0, maxLoc = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[maxLoc]) maxLoc = i;
        }

        int peek = 0;
        for (int i = 0; i < maxLoc; i++) {
            if (height[i] > peek) peek = height[i];
            water += peek - height[i];
        }
        peek = 0;
        for (int i = height.length - 1; i > maxLoc; i--) {
            if (height[i] > peek) peek = height[i];
            water += peek - height[i];
        }
        return water;
    }
}
