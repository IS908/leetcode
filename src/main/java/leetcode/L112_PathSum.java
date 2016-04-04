package leetcode;

import leetcode.Utils.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * <p/>
 * For example:
 * Given the below binary tree and sum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * / \      \
 * 7   2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * <p/>
 * Created by kevin on 2016/4/2.
 */
public class L112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)   return false;
        return containsPathSum(root, sum, 0);
    }

    private boolean containsPathSum(TreeNode node, int sum, int cur) {
        cur += node.val;
        if (node.left == null && node.right == null) {
            return sum == cur;
        }
        boolean flag = false;
        if (node.left != null)  flag = flag || containsPathSum(node.left, sum, cur);
        if (node.right != null) flag = flag || containsPathSum(node.right, sum, cur);
        return flag;
    }
}
