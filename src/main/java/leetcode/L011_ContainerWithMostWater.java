package leetcode;

/**
 Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container.

 * Created by kevin on 2016/2/29.
 */
public class L011_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxWater=0, currentWater;
        for (int i=0, j=height.length-1; i<j;) {
            currentWater = (j-i)*Math.min(height[i], height[j]);
            maxWater = currentWater > maxWater? currentWater: maxWater;
            if (height[i] < height[j]) {
                i++;
            }else{
                j--;
            }
        }
        return maxWater;
    }
}
