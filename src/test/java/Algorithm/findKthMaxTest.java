package Algorithm;

import org.junit.Test;

/**
 * Created by kevin on 2016/4/5.
 */
public class findKthMaxTest {
    @Test
    public void test() {
        findKthMax kthMax = new findKthMax();
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int res = kthMax.kthMaxNumber(arr, 3);
        System.out.println(res);
    }
}
