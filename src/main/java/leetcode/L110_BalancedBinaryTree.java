package leetcode;

import leetcode.Utils.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * <p/>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p/>
 * Created by kevin on 2016/3/26.
 */
public class L110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null)   return true;
        return postOrder(root) > -1;
    }

    private int postOrder(TreeNode node) {
        if (node == null) return 0;
        int left = postOrder(node.left);
        int right = postOrder(node.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
