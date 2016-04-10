package leetcode;

import leetcode.Utils.TreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 * <p/>
 * 1
 * / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 * <p/>
 * Created by kevin on 2016/4/10.
 */
public class L129_SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return countNum(root, 0);
    }
    private int countNum(TreeNode node, int sum) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return sum * 10 + node.val;
        return countNum(node.left, sum * 10 + node.val) + countNum(node.right, sum * 10 + node.val);
    }
}
