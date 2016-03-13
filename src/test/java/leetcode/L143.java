package leetcode;

import leetcode.Utils.ListNode;
import leetcode.Utils.SingleList;
import org.junit.Test;

/**
 * Created by kevin on 2016/3/13.
 */
public class L143 {
    @Test
    public void test() {
        L143_ReorderList reorderList = new L143_ReorderList();
        SingleList list = new SingleList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        ListNode head = list.getHead();
        reorderList.reorderList(head);
        head.Print();
    }
}
