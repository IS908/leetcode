package Algorithm;

import java.util.Arrays;

/**
 * 最少时间复杂度求数组中第k大的数
 * <p/>
 * Created by kevin on 2016/4/5.
 */
public class findKthMax {

    public int kthMaxNumber(int[] arr, int k) {
        // 快排方式实现求第k大的数
        QuickSortGetKth(arr, k, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        return arr[k - 1];

        // 小顶堆方式实现求第k大的数
        /*heapBuile(arr, k);
        insertNum(arr, k, arr[0]);
        for (int i = k + 1; i < arr.length; i++) {
            insertNum(arr, k, arr[i]);
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        return arr[1];*/
    }


    // 快排方式实现
    private void QuickSortGetKth(int[] arr, int k, int start, int end) {
        if (start < end) {
            int loc = partition(arr, k, start, end);
            if (loc + 1 == k) {
                return;
            } else if (loc + 1 > k) {
                QuickSortGetKth(arr, k, start, loc - 1);
            } else {
                QuickSortGetKth(arr, k, loc + 1, end);
            }
        }
    }

    private int partition(int[] arr, int k, int start, int end) {
        //median3(arr, start, end);
        int pivot = arr[end];
        while (start < end) {
            while (start < end && arr[start] >= pivot) start++;
            if (start < end) arr[end--] = arr[start];
            while (start < end && arr[end] <= pivot) end--;
            if (start < end) arr[start++] = arr[end];
        }
        arr[end] = pivot;
        return end;
    }

    private void median3(int[] arr, int left, int right) {
        int mid = (left + right) >>> 1;
        int low = arr[left];
        if (arr[mid] < low) {
            arr[left] = arr[mid];
            arr[mid] = low;
        }
        low = arr[left];
        if (arr[right] < low) {
            arr[left] = arr[right];
            arr[right] = low;
        }
        if (arr[mid] < arr[right]) {
            int center = arr[mid];
            arr[mid] = arr[right];
            arr[right] = center;
        }
    }

    private void insertNum(int[] arr, int heapLen, int num) {
        if (num < arr[1]) return;
        arr[1] = num;
        percolateDown(arr, 1, heapLen);
    }

    /**
     * 创建小顶堆
     *
     * @param arr
     * @param heapLen
     */
    private void heapBuile(int[] arr, int heapLen) {
        for (int i = (heapLen >>> 1); i > 0; i--) {
            percolateDown(arr, i, heapLen);
        }
    }

    private void percolateDown(int[] arr, int hole, int heapLen) {
        int child;
        int tmp = arr[hole];
        for (; hole * 2 <= heapLen; hole = child) {
            child = hole * 2;
            if (child != heapLen && arr[child + 1] < arr[child]) {
                child++;
            }
            if (arr[child] < tmp) {
                arr[hole] = arr[child];
            } else {
                break;
            }
        }
        arr[hole] = tmp;
    }
}
