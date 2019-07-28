package Algorithm.array.matrix;

/**
 * @Description: 求子矩阵的最大累加和
 * <p>
 * 给定一个矩阵matrix，其中的值有正、有负、有0，返回子矩阵的最大累加和。
 * <p>
 * 例如，矩阵matrix为：
 * -90　48　78
 * 64　-40　64
 * -81　-7　66
 * 其中，最大累加和的子矩阵为：
 * 48　78
 * -40　64
 * -7　66
 * 所以返回累加和209。
 * @Auther: kun
 * @Date: 2019-07-28 23:22
 */
public class MaxSumOfSubMatrix {

    public int maxSum(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        // 累加数组
        int[] s = null;
        for (int i = 0; i != m.length; i++) {
            s = new int[m[0].length];
            for (int j = i; j != m.length; j++) {
                cur = 0;
                for (int k = 0; k != s.length; k++) {
                    s[k] += m[j][k];
                    cur += s[k];
                    max = Math.max(max, cur);
                    cur = cur < 0 ? 0 : cur;
                }
            }
        }
        return max;
    }

}
