package leetcode;

import leetcode.Utils.TreeNode;

/**
 * Given a binary tree, find the maximum path sum.
 * <p/>
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path does not need to go through the root.
 * <p/>
 * For example:
 * Given the below binary tree,
 * <p/>
 * 1
 * / \
 * 2   3
 * Return 6.
 * <p/>
 * Created by kevin on 2016/4/21.
 */
public class L124_BinaryTreeMaximumPathSum {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }

    private int maxSum(TreeNode node) {
        if (node == null) return 0;
        int cur = node.val;
        int lmax, rmax, curSum = cur;
        lmax = Math.max(maxSum(node.left), 0);
        rmax = Math.max(maxSum(node.right), 0);
        curSum += lmax + rmax;
        if (curSum > max)  max = curSum;
        return cur + Math.max(lmax, rmax);
    }
}
