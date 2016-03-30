package leetcode;

import leetcode.Utils.TreeNode;

import java.util.Stack;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p/>
 * For example, this binary tree is symmetric:
 * <p/>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * <p/>
 * Created by kevin on 2016/3/26.
 */
public class L101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        if (root.left == null || root.right == null) return false;
        return symmetricOrder(root.left, root.right);
    }

    /**
     * 先序遍历检验是否对称
     * @param first
     * @param second
     * @return
     */
    private boolean symmetricOrder(TreeNode first, TreeNode second) {
        TreeNode node1, node2;
        Stack<TreeNode> one = new Stack<>();
        Stack<TreeNode> two = new Stack<>();
        one.push(first);
        two.push(second);
        while (!one.isEmpty() && !two.isEmpty()) {
            node1 = one.pop();
            node2 = two.pop();
            if (node1.val != node2.val) return false;
            if (node1.left != null && node2.right != null) {
                one.push(node1.left);
                two.push(node2.right);
            } else if (node1.left != null || node2.right != null) {
                return false;
            }
            if (node1.right != null && node2.left != null) {
                one.push(node1.right);
                two.push(node2.left);
            } else if (node1.right != null || node2.left != null) {
                return false;
            }
        }
        return true;
    }
}
