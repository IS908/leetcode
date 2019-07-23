package Algorithm.tree;

import leetcode.Utils.TreeNode;

/**
 * @Description: 在二叉树中找到两个节点的最近公共祖先
 * @Auther: kun
 * @Date: 2019-07-23 11:35
 */
public class LowestAncestor {

    public TreeNode lowestAncestor(TreeNode head, TreeNode o1, TreeNode o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        TreeNode left = lowestAncestor(head.left, o1, o2);
        TreeNode right = lowestAncestor(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }

}
