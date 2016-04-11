package leetcode;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * <p/>
 * Created by kevin on 2016/4/11.
 */
public class L088_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = m - 1, n2 = n - 1, cur = m + n - 1;
        while (n1 >= 0 && n2 >= 0) {
            if (nums1[n1] > nums2[n2]) {
                nums1[cur--] = nums1[n1--];
            } else {
                nums1[cur--] = nums2[n2--];
            }
        }

        while (n2 >= 0) {
            nums1[cur--] = nums2[n2--];
        }
    }
}
