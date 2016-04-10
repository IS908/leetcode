package leetcode;

import leetcode.Utils.ListNode;
import leetcode.Utils.TreeNode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p/>
 * Created by kevin on 2016/4/2.
 */
public class L109_ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            len++;
        }
        Hashtable hashtable;
        HashMap map;
        HashSet set;
        List list;
        ArrayList list1;
        return null;
    }
}
