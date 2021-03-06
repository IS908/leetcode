package leetcode;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * <p/>
 * Created by kevin on 2016/3/7.
 */
public class L073_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int m = 1, n = 1;
        // 标记第一列是否含有0
        for (int i = 0; i < matrix.length; i++) {
            if (0 == matrix[i][0])
                m = 0;
        }
        // 标记第一行是否含有0
        for (int i = 0; i < matrix[0].length; i++) {
            if (0 == matrix[0][i])
                n = 0;
        }

        // 遍历标记
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (0 == matrix[i][j]) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 根据第一列标记，将相应行置0
        for (int i = 1; i < matrix.length; i++) {
            if (0 == matrix[i][0]) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 根据第一行标记，将相应列置0
        for (int i = 1; i < matrix[0].length; i++) {
            if (0 == matrix[0][i]) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        // 单独处理第一行
        if (n == 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        // 单独处理第一列
        if (m == 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
