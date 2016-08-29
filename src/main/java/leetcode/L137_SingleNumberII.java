package leetcode;

/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * <p/>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p/>
 * Created by kevin on 2016/3/8.
 */
public class L137_SingleNumberII {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += (nums[j] >> i) & 1;
            }
            result |= ((sum % 3) << i);
        }
        return result;
    }

    /**
     * 用one记录到当前处理的元素为止，二进制1出现“1次”(mod 3 之后的1)的有哪些二进制位；
     * 用two记录到当前计算的变量为止，二进制1出现“2次”(mod 3 之后的2)的有哪些二进制为；
     * 当one和two中的某一位同时为1时表示该二进制位上1出现了3次，此时需要清零。
     * 即 用二进制模拟三进制运算。最终 one 记录的是最终结果。
     * @param nums
     * @return
     */
    @Deprecated
    // TODO: 16-8-29 待研究
    public int singleNumber02(int[] nums) {
        int one = 0, two = 0, three = 0;
        for (int i : nums) {
            two |= (one & i);
            one ^= i;
            three = ~(one & two);
            one &= three;
            two &= three;
        }
        return one;
    }
}
