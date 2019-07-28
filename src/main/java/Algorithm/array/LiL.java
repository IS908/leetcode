package Algorithm.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Description: 最长的可整合子数组的长度
 * <p>
 * 先给出可整合数组的定义。如果一个数组在排序之后，每相邻两个数差的绝对值都为1，则该数组为可整合数组。
 * 例如，[5，3，4，6，2]排序之后为[2，3，4，5，6]，符合每相邻两个数差的绝对值都为1，所以这个数组为可整合数组。
 * <p>
 * 给定一个整型数组arr，请返回其中最大可整合子数组的长度。
 * 例如，[5，5，3，2，6，4，3]的最大可整合子数组为[5，3，2，6，4]，所以返回5。
 * @Auther: kun
 * @Date: 2019-07-28 14:40
 */
public class LiL {

    /**
     * 时间复杂度为 O(N^3logN)
     *
     * @param arr
     * @return
     */
    public int getLIL1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (isIntegrated(arr, i, j)) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }

    public boolean isIntegrated(int[] arr, int left, int right) {
        int[] newArr = Arrays.copyOfRange(arr, left, right + 1); // O(N)
        Arrays.sort(newArr); // O(N*logN)
        for (int i = 1; i < newArr.length; i++) {
            if (newArr[i - 1] != newArr[i] - 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 时间复杂度为 O(N^2)
     *
     * @param arr
     * @return
     */
    public int getLIL2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = 0;
        int max = 0;
        int min = 0;
        // 判断重复
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                if (set.contains(arr[j])) {
                    break;
                }
                set.add(arr[j]);
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                if (max - min == j - i) {
                    // 新的检查方式
                    len = Math.max(len, j - i + 1);
                }
            }
            set.clear();
        }
        return len;
    }

}
