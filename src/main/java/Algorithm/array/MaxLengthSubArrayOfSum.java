package Algorithm.array;

/**
 * @Description: 未排序正数数组中累加和为给定值的最长子数组长度
 * <p>
 * 给定一个数组arr，该数组无序，但每个值均为正数，再给定一个正数k。求arr的所有子数组中所有元素相加和为k的最长子数组长度。
 * <p>
 * 例如，arr=[1，2，1，1，1]，k=3。
 * <p>
 * 累加和为3的最长子数组为[1，1，1]，所以结果返回3。
 * @Auther: kun
 * @Date: 2019-07-28 14:57
 */
public class MaxLengthSubArrayOfSum {

    public int getMaxLength(int[] arr, int k) {
        if (arr == null || arr.length < 1 || k <= 0) {
            return 0;
        }
        int maxlen = 0, sum = arr[0], left = 0, right = 0;
        while (right < arr.length) {
            if (sum == k) {
                maxlen = Math.max(maxlen, right - left + 1);
                sum -= arr[left++];
                continue;
            }
            if (sum < k) {
                right++;
                if (right == arr.length) {
                    break;
                }
                sum += arr[right];
            } else {
                sum -= arr[left--];
            }
        }
        return maxlen;
    }

}
