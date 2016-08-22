package leetcode;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * <p/>
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * <p/>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p/>
 * Note: Given n will be between 1 and 9 inclusive.
 * <p/>
 * Created by kevin on 2016/3/5.
 */
public class L060_PermutationSequence {
    // 康托编码
    public String getPermutation(int n, int k) {
        int res = Cantor(n, k);
        return String.valueOf(res);
    }

    /**
     * 计算给定数是全排列中第几大的数
     *
     * @param n 全排列位数
     * @param m 给定的数
     * @return
     */
    public int KT(int n, int m) {
        String mStr = String.valueOf(m);
        int result = 1;
        if (n < 2) return result;

        int[] level = new int[n + 1];  // 缓存阶乘结果
        level[0] = 1;
        for (int i = 1; i <= n; i++) level[i] = level[i - 1] * i;

        // 康托计算
        boolean[] flag = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            int cur = mStr.charAt(i) - '0';
            int count = cur - 1;
            for (int j = 1; j < cur; j++) {
                if (flag[j]) count--;
            }
            flag[cur] = true;
            result += count * level[n - i - 1];
        }
        return result;
    }

    /**
     * 给定全排列位数和数字K，返回全排列中第 K 大的数
     *
     * @param n 全排列位数
     * @param k 给定的数K
     * @return
     */
    public int Cantor(int n, int k) {
        if (n < 1) return -1;

        int[] level = new int[n];  // 缓存阶乘结果
        level[0] = 1;
        for (int i = 1; i < n; i++) {
            level[i] = level[i - 1] * i;
        }

        int result = 0;
        boolean[] flag = new boolean[n + 1];
        k--;
        for (int i = 0; i < n; i++) {
            int cur = k / level[n - i - 1];
            int j = 1;
            // 从头开始找到 cur 个坑位为尚未填写的数字
            for (; j <= n; j++) {
                if (!flag[j]) {
                    if (cur == 0) break;
                    --cur;
                }
            }
            flag[j] = true;
            result = result * 10 + j;
            k = k % level[n - i - 1];
        }

        return result;
    }

    public static void main(String[] args) {
        L060_PermutationSequence permutationSequence = new L060_PermutationSequence();
        int res = permutationSequence.KT(9, 357412968);
        System.out.println(res);
    }
}
