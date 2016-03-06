package leetcode;

import org.junit.Test;

import java.util.List;

/**
 * Created by kevin on 2016/2/29.
 */
public class L015 {
    @Test
    public void test() {
        L015_3Sum l015 = new L015_3Sum();
        int[] arr = new int[]{-2, -1, 0, 1, 2, 3};
        List<List<Integer>> list = l015.threeSum(arr);
        for (List<Integer> l: list) {
            for (int tmp: l) {
                System.out.print(tmp + "\t");
            }
            System.out.println();
        }
    }
}
