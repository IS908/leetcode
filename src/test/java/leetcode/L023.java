package leetcode;

import leetcode.Utils.ListNode;
import org.junit.Test;

/**
 * Created by kevin on 2016/3/3.
 */
public class L023 {
    @Test
    public void test() {
        L023_MergeKSortedLists l023 = new L023_MergeKSortedLists();
        ListNode[] lists = new ListNode[3];
        l023.mergeKLists(lists);
    }
}
