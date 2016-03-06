package leetcode;

import org.junit.Test;

import java.util.List;

/**
 * Created by kevin on 2016/3/2.
 */
public class L018 {
    @Test
    public void test() {
        L018_4Sum l018 = new L018_4Sum();
        int[] arr = {-3, -2, -1, 0, 0, 1, 2, 3};
        List<List<Integer>> list = l018.fourSum(arr, 0);
        for (List<Integer> list1: list) {
            for (int tmp: list1) {
                System.out.print(tmp);
            }
            System.out.println();
        }
    }
}
