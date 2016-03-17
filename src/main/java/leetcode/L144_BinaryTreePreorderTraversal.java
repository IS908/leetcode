package leetcode;

import leetcode.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p/>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,2,3].
 * <p/>
 * Note: Recursive solution is trivial, could you do it iteratively?
 * <p/>
 * Created by kevin on 16-3-17.
 */
public class L144_BinaryTreePreorderTraversal {
    /**
     * 非递归实现
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null)   stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return list;
    }

    /**
     * 递归实现
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal01(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversalTree(root, list);
        return list;
    }

    private void preorderTraversalTree(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        preorderTraversalTree(node.left, list);
        preorderTraversalTree(node.right, list);
    }
}
