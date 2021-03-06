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

    /**
     * 给定一个无序数组arr，其中元素可正、可负、可0，给定一个整数k。求arr所有的子数组中累加和小于或等于k的最长子数组长度。
     * <p>
     * 例如：arr=[3，-2，-4，0，6]，k=-2，相加和小于或等于-2的最长子数组为{3，-2，-4，0}，所以结果返回4。
     *
     * @param arr
     * @param k
     * @return
     */
    public int maxLength3(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] sumArr = new int[arr.length];
        int[] helpArr = new int[arr.length];
        int sum = 0, max = 0, len = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(sum, max);
            helpArr[i] = max;
            sumArr[i] = sum;
            sum += arr[i];
        }
        for (int i = 0; i < sumArr.length; i++) {
            int cur = sumArr[i] - k;
            int index = findLessIndex(helpArr, i, cur);
            if (index > 0) {
                len = Math.max(len, cur - index + 1);
            }
        }
        return len;
    }

    private int findLessIndex(int[] arr, int curIndex, int num) {
        int low = 0;
        int high = curIndex;
        int mid = 0;
        int res = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] >= num) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public int maxLength4(int[] arr, int k) {
        int[] h = new int[arr.length + 1];
        int sum = 0;
        h[0] = sum;
        for (int i = 0; i != arr.length; i++) {
            sum += arr[i];
            h[i + 1] = Math.max(sum, h[i]);
        }
        sum = 0;
        int res = 0;
        int pre = 0;
        int len = 0;
        for (int i = 0; i != arr.length; i++) {
            sum += arr[i];
            pre = getLessIndex(h, sum - k);
            len = pre == -1 ? 0 : i - pre + 1;
            res = Math.max(res, len);
        }
        return res;
    }

    public int getLessIndex(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int res = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] >= num) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

}
