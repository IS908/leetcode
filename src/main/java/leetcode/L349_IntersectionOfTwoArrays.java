package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * Created by chenkunsi2782 on 2016/6/23.
 */
public class L349_IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int len = nums1.length;
        int index = 0;
        for (int i = 0; i < len; i++) {
            while (index < nums2.length && nums1[i] > nums2[index]) {
                index++;
            }
            if (index >= nums2.length) {
                break;
            }
            if (nums1[i] == nums2[index]) {
                set.add(nums1[i]);
            }
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (int tmp: set) {
            result[i++] = tmp;
        }
        return result;
	}
}
