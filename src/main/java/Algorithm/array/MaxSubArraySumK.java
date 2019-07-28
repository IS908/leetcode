package Algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 未排序数组中累加和为给定值的最长子数组系列问题
 * @Auther: kun
 * @Date: 2019-07-28 15:39
 */
public class MaxSubArraySumK {

    /**
     * 给定一个无序数组arr，其中元素可正、可负、可0，给定一个整数k。求arr所有的子数组中累加和为k的最长子数组长度。
     *
     * @param arr
     * @param k
     * @return
     */
    public int maxLength(int[] arr, int k) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, len = 0;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int remain = sum - k;
            if (map.containsKey(remain)) {
                len = Math.max(len, i - map.get(remain));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }

    /**
     * 给定一个无序数组arr，其中元素可正、可负、可0。求arr所有的子数组中正数与负数个数相等的最长子数组长度。
     *
     * @param arr
     * @return
     */
    public int maxLength1(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int[] a = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                a[i] = 0;
            } else {
                a[i] = arr[i] > 0 ? 1 : -1;
            }
        }
        return maxLength(a, 0);
    }

    /**
     * 给定一个无序数组arr，其中元素只是1或0。求arr所有的子数组中0和1个数相等的最长子数组长度。
     *
     * @param arr
     * @return
     */
    public int maxLength2(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int[] a = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                a[i] = -1;
            } else {
                a[i] = 1;
            }
        }
        return maxLength(a, 0);
    }
}
