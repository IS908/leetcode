package leetcode;

import leetcode.Utils.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p/>
 * Assume a BST is defined as follows:
 * <p/>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p/>
 * Created by kevin on 2016/4/1.
 */
public class L098_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        return root.val > min && root.val < max &&
                isValidBST(root.left, min, root.val) &&
                isValidBST(root.right, root.val, max);
    }

    /*public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;
        return isValidBST(root.left, min, root.val) &&
                isValidBST(root.right, root.val, max);
    }*/
}
