package Algorithm.recursionAndDynamic;

/**
 * @Description: 排成一条线的纸牌博弈问题
 * <p>
 * 给定一个整型数组arr，代表数值不同的纸牌排成一条线。
 * 玩家A和玩家B依次拿走每张纸牌，规定玩家A先拿，玩家B后拿，但是每个玩家每次只能拿走最左或最右的纸牌，玩家A和玩家B都绝顶聪明。
 * <p>
 * 请返回最后获胜者的分数
 * @Auther: kun
 * @Date: 2019-07-26 15:48
 */
public class Win {

    /**
     * 时间复杂度(2^N)，空间复杂度(N^2)
     *
     * @param arr
     * @return
     */
    public int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    /**
     * 先手做出选择
     *
     * @param arr
     * @param i
     * @param j
     * @return
     */
    public int f(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
    }

    /**
     * 后手做出选择
     *
     * @param arr
     * @param i
     * @param j
     * @return
     */
    public int s(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }

    /**
     * 时间复杂度(N^2)，空间复杂度(N^2)
     *
     * @param arr
     * @return
     */
    public int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for (int j = 0; j < arr.length; j++) {
            f[j][j] = arr[j];
            for (int i = j - 1; i >= 0; i--) {
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }


}
