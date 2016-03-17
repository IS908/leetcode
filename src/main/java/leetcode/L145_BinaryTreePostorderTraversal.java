package leetcode;

import leetcode.Utils.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * <p/>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [3,2,1].
 * <p/>
 * Created by kevin on 16-3-17.
 */
public class L145_BinaryTreePostorderTraversal {
    /**
     * 非递归实现 后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                stack.push(node.right);
                node = node.left;
            } else {
                while ((node = stack.pop()) == null);
                list.add(node.val);
            }
        }
        return list;
    }

    /**
     * 递归实现 后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal01(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversalTree(root, list);
        return list;
    }

    private void postorderTraversalTree(TreeNode node, List<Integer> list) {
        if (node == null) return;
        postorderTraversalTree(node.left, list);
        postorderTraversalTree(node.right, list);
        list.add(node.val);
    }
}
