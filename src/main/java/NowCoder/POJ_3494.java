package NowCoder;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by kevin on 16-8-9.
 */
public class POJ_3494 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> results = new ArrayList<Integer>();
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();
            int[][] matrix = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            int res = getSubMitrix(matrix);
            results.add(res);
        }

        for (int i : results) {
            System.out.println(i);
        }
    }

    /**
     * 求最大的子矩阵
     *
     * @param matrix
     * @return
     */
    private static int getSubMitrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i - 1][j] != 0 && matrix[i][j] != 0)
                    matrix[i][j] += matrix[i - 1][j];
            }
        }

        int res = 0;
        for (int i = 0; i < matrix.length; i++)
            res = Math.max(maxRectangle(matrix[i]), res);

        return res;
    }

    /**
     * 求面积最大的矩形
     *
     * @param h
     * @return
     */
    private static int maxRectangle(int[] h) {
        int max = 0;
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < h.length; i++) {
            if (s.isEmpty()) {
                s.push(i);
                continue;
            }
            if (h[i] <= h[s.peek()]) {
                int curPos = s.pop();
                int heigh = h[curPos];
                int left = s.isEmpty() ? 0 : s.peek();
                int cur = heigh * (curPos - left + 1);
                max = Math.max(max, cur);
            } else {
                s.push(i);
            }
        }
        return max;
    }
}
