package leetcode;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p/>
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * <p/>
 * Follow up:
 * <p/>
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)).
 * But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 * <p/>
 * Created by kevin on 2016/4/1.
 */
public class L338_CountingBits {
    // O(n) 时间复杂度
    public int[] countBits1(int num) {
        if (num < 1) return new int[]{0};
        int[] bits = new int[num + 1];
        bits[0] = 0;
        bits[1] = 1;
        for (int i = 2; i <= num; i++) {
            bits[i] = bits[i / 2] + i % 2;
        }
        return bits;
    }

    // 位运算计算每个数的bit为1的个数
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int count = 0;
            for (int j = i; j > 0; j = j & (j - 1), count++) ;
            bits[i] = count;
        }
        return bits;
    }
}
