package Algorithm.array.matrix;

/**
 * @Description: 将正方形矩阵顺时针转动90°
 * @Auther: kun
 * @Date: 2019-07-27 17:21
 */
public class Rotate {

    public void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        int times = dC - tC;
        // times就是总的组数
        int tmp = 0;
        for (int i = 0; i != times; i++) {
            // 一次循环就是一组占据调整
            tmp = m[tR][tC + i];
            m[tR][tC + i] = m[dR - i][tC];
            m[dR - i][tC] = m[dR][dC - i];
            m[dR][dC - i] = m[tR + i][dC];
            m[tR + i][dC] = tmp;
        }
    }


}
