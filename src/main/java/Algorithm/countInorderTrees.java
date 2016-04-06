package Algorithm;

/**
 * 长度为N的序列Sequence=abcd...，问有多少种不同的二叉树形态中序遍历是这个，写递推公式
 * <p/>
 * Created by kevin on 2016/4/6.
 */
public class countInorderTrees {
    public int inorderTreeNums(int n) {
        int[] counts = new int[n + 1];
        counts[0] = 1;
        counts[1] = 1;
        counts[2] = 2;
        for (int i = 3; i <= n; i++) {
            counts[i] = 0;
            for (int j = 0; j < i; j++) {
                counts[i] += counts[j] * counts[i - j - 1];
            }
        }
        return counts[n];
    }
}
