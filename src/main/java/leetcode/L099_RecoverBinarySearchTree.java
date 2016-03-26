package leetcode;

import leetcode.Utils.TreeNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * <p/>
 * Recover the tree without changing its structure.
 * <p/>
 * Created by kevin on 2016/3/20.
 */
@Deprecated
public class L099_RecoverBinarySearchTree {
    TreeNode first, second, pre;

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        inOrder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    // 通过中序遍历，只不过，不需要存储每个节点，只需要存一个前驱即可。
    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        if (pre == null) {
            pre = node;
        } else {
            if (pre.val > node.val) {
                if (first == null) {
                    first = pre;
                }
                second = node;
            }
            pre = node;
        }
        inOrder(node.right);
    }
}
