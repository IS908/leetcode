package leetcode;

import leetcode.Utils.ListNode;
import leetcode.Utils.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p/>
 * Created by kevin on 2016/4/2.
 */
public class L109_ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        int len = listLength(head);
//        TreeNode root = sortedListToBST(head, 0, len - 1);
        TreeNode[] nodes = listToArray(head);
        TreeNode root = sortedListToBST(nodes, 0, len - 1);
        return root;
    }

    /**
     * 自底向上创建树
     *
     * @param node
     * @param start
     * @param end
     * @return
     */
    private TreeNode sortedListToBST(TreeNode[] node, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode leftChild = sortedListToBST(node, start, mid - 1);
        TreeNode parent = node[mid];
        parent.left = leftChild;
        TreeNode rightChild = sortedListToBST(node, mid + 1, end);
        parent.right = rightChild;
        return parent;
    }

    /**
     * 将链表转化为数组
     *
     * @param list
     * @return
     */
    private TreeNode[] listToArray(ListNode list) {
        int len = listLength(list);
        ListNode cur = list;
        TreeNode[] nodes = new TreeNode[len];
        for (int i = 0; i < len; i++) {
            nodes[i] = new TreeNode(cur.val);
            cur = cur.next;
        }
        return nodes;
    }

    private TreeNode sortedListToBST(ListNode list, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode leftChild = sortedListToBST(list, start, mid - 1);
        TreeNode parent = new TreeNode(nth_Node(list, mid).val);
        parent.left = leftChild;
        list = list.next;
        parent.right = sortedListToBST(list, mid + 1, end);

        return parent;
    }

    /**
     * 取得该位置之后的第 n 个节点
     *
     * @param list
     * @param n
     * @return
     */
    private ListNode nth_Node(ListNode list, int n) {
        ListNode cur = list;
        while (n > 0) {
            n--;
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 计算链表的长度
     *
     * @param list
     * @return
     */
    private int listLength(ListNode list) {
        if (list == null) return 0;
        int len = 0;
        ListNode cur = list;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        return len;
    }
}
