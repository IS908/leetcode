package saima;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kevin on 16-8-17.
 */
public class Main03 {
    private static int[] arr;
    private static int[][] res;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int n, k;
        res = new int[num][];
        for (int i = 0; i < num; i++) {
            n = in.nextInt();
            k = in.nextInt();
            arr = new int[2 * n];
            for (int j = 0; j < 2 * n; j++) {
                arr[j] = in.nextInt();
            }
            getRes(i, n, k);
        }
        for (int[] array : res) {
            for (int i = 0; i < array.length - 1; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println(array[array.length - 1]);
        }
    }

    private static void getRes(int cur, int n, int k) {
        if (k == 0) {
            res[cur] = arr;
            return;
        }
        int[] arr1 = Arrays.copyOfRange(arr, 0, n);
        int[] arr2 = Arrays.copyOfRange(arr, n, arr.length);
        for (int i = n - 1; i >= 0; i--) {
            arr[i * 2 + 1] = arr2[i];
            arr[i * 2] = arr1[i];
        }
        getRes(cur, n, k - 1);
    }
}
