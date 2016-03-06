package leetcode;

import org.junit.Test;

/**
 * Created by kevin on 2016/3/3.
 */
public class L080 {
    @Test
    public void test() {
        L080_RemoveDuplicatesFromSortedArrayII l080 = new L080_RemoveDuplicatesFromSortedArrayII();
        int[] arr = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
        int res = l080.removeDuplicates(arr);
        System.out.println(res);
    }
}
