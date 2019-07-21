package leetcode;

/**
 * @Description: 给出一个数组，奇数序号降序，偶数序号升序，要求重排成重小到大的数组，时间复杂度为O(n)
 * @Auther: kun
 * @Date: 2019-06-27 09:04
 */
public class ReSortArray {

    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int[] a = new int[arr.length];

        int len = arr.length;
        int left, right = len - 1;
        if ((len & 1) == 0) { // right 为奇数
            left = 0;
        } else { // right 为偶数
            left = 1;
        }
        for (int i = 0; i < len; i++) {
            int index = 0;
            if (left < len && right > 0) {
                if (arr[left] > arr[right]) {
                    index = right;
                    right -= 2;
                } else {
                    index = left;
                    left += 2;
                }
            } else if (left < len) {
                index = left;
                left += 2;
            } else if (right > 0) {
                index = right;
                right -= 2;
            }
            a[i] = arr[index];
        }

        for (int i = 0; i < len; i++) {
            arr[i] = a[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 20, 2, 18, 3, 2};
        ReSortArray sortArray = new ReSortArray();
        sortArray.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
