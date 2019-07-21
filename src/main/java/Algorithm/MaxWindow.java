package Algorithm;

import java.util.LinkedList;

/**
 * @Description: 生成窗口最大值数组
 * 有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个位置
 * <p>
 * 例如，数组为[4，3，5，4，3，3，6，7]，窗口大小为3时：
 * [4 3 5] 4 3 3 6 7 窗口中最大值为5
 * 4 [3 5 4] 3 3 6 7 窗口中最大值为5
 * 4 3 [5 4 3] 3 6 7 窗口中最大值为5
 * 4 3 5 [4 3 3] 6 7 窗口中最大值为4
 * 4 3 5 4 [3 3 6] 7 窗口中最大值为6
 * 4 3 5 4 3 [3 6 7] 窗口中最大值为7
 * @Auther: kun
 * @Date: 2019-07-18 22:05
 */
public class MaxWindow {

    public int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }

        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] < arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            while (qmax.peekFirst() < i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

}
