package Algorithm.array;

/**
 * @Description: 子数组的最大累加和问题
 * <p>
 * 给定一个数组arr，返回子数组的最大累加和。
 * <p>
 * 例如，arr=[1，-2，3，5，-2，6，-1]，所有的子数组中，[3，5，-2，6]可以累加出最大的和12，所以返回12。
 * @Auther: kun
 * @Date: 2019-07-28 23:09
 */
public class MaxSumOfSubArray {

    public int maxSum(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE, sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += arr[i];
            max = Math.max(max, sum);
        }

        return max;
    }

}
