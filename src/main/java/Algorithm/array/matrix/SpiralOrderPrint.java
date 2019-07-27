package Algorithm.array.matrix;

/**
 * @Description: 转圈打印矩阵
 * <p>
 * 给定一个整型矩阵matrix，请按照转圈的方式打印它。
 * @Auther: kun
 * @Date: 2019-07-27 17:19
 */
public class SpiralOrderPrint {

    public void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        if (tR == dR) {
            // 子矩阵只有一行时
            for (int i = tC; i <= dC; i++) {
                System.out.print(m[tR][i] + " ");
            }
        } else if (tC == dC) {
            // 子矩阵只有一列时
            for (int i = tR; i <= dR; i++) {
                System.out.print(m[i][tC] + " ");
            }
        } else { // 一般情况
            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                System.out.print(m[tR][curC] + " ");
                curC++;
            }
            while (curR != dR) {
                System.out.print(m[curR][dC] + " ");
                curR++;
            }
            while (curC != tC) {
                System.out.print(m[dR][curC] + " ");
                curC--;
            }
            while (curR != tR) {
                System.out.print(m[curR][tC] + " ");
                curR--;
            }
        }
    }


}
