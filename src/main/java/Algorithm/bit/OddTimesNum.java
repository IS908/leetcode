package Algorithm.bit;

/**
 * @Description: 在其他数都出现偶数次的数组中找到出现奇数次的数
 * @Auther: kun
 * @Date: 2019-07-27 17:00
 */
public class OddTimesNum {

    /**
     * 给定一个整型数组arr，其中只有一个数出现了奇数次，其他的数都出现了偶数次，打印这个数。
     *
     * @param arr
     */
    public void printOddTimesNum1(int[] arr) {
        int eO = 0;
        for (int cur : arr) {
            eO ^= cur;
        }
        System.out.println(eO);
    }

    /**
     * 有两个数出现了奇数次，其他的数都出现了偶数次，打印这两个数。
     *
     * @param arr
     */
    public static void printOddTimesNum2(int[] arr) {
        int eO = 0, eOhasOne = 0;
        for (int curNum : arr) {
            eO ^= curNum;
        }
        int rightOne = eO & (~eO + 1);
        for (int cur : arr) {
            if ((cur & rightOne) != 0) {
                eOhasOne ^= cur;
            }
        }
        System.out.println(eOhasOne + " " + (eO ^ eOhasOne));
    }

}
