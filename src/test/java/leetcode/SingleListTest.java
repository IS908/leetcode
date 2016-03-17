package leetcode;

import leetcode.Utils.ListNode;
import leetcode.Utils.SingleList;
import org.junit.Test;

/**
 * Created by kevin on 2016/3/13.
 */
public class SingleListTest {
    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        SingleList list = new SingleList(nums);
        ListNode head = list.getHead();
        head.print();
    }
}
