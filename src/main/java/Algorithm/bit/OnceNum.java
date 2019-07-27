package Algorithm.bit;

/**
 * @Description: 在其他数都出现k次的数组中找到只出现一次的数
 * <p>
 * 给定一个整型数组arr和一个大于1的整数k。
 * 已知arr中只有1个数出现了1次，其他的数都出现了k次，请返回只出现了1次的数。
 * @Auther: kun
 * @Date: 2019-07-27 17:13
 */
public class OnceNum {

    public int onceNum(int[] arr, int k) {
        int[] eO = new int[32];
        for (int i = 0; i != arr.length; i++) {
            setExclusiveOr(eO, arr[i], k);
        }
        int res = getNumFromKSysNum(eO, k);
        return res;
    }

    public void setExclusiveOr(int[] eO, int value, int k) {
        int[] curKSysNum = getKSysNumFromNum(value, k);
        for (int i = 0; i != eO.length; i++) {
            eO[i] = (eO[i] + curKSysNum[i]) % k;
        }
    }

    public int[] getKSysNumFromNum(int value, int k) {
        int[] res = new int[32];
        int index = 0;
        while (value != 0) {
            res[index++] = value % k;
            value = value / k;
        }
        return res;
    }

    public int getNumFromKSysNum(int[] eO, int k) {
        int res = 0;
        for (int i = eO.length - 1; i != -1; i--) {
            res = res * k + eO[i];
        }
        return res;
    }

}
