package leetcode;

import leetcode.Utils.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p/>
 * Created by kevin on 2016/3/30.
 */
public class L105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null) return null;
        TreeNode root = buildByPreIn(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }

    public TreeNode buildByPreIn(int[] preorder, int[] inorder, int p_s, int p_e, int i_s, int i_e) {
        if (p_s > p_e) return null;
        int pivot = preorder[p_s];
        int loc = i_s;
        for (; loc < i_e; loc++) {
            if (pivot == inorder[loc]) break;
        }
        int len = loc - i_s;
        TreeNode node = new TreeNode(pivot);
        node.left = buildByPreIn(preorder, inorder, p_s + 1, p_s + len, i_s, loc - 1);
        node.right = buildByPreIn(preorder, inorder, p_s + len + 1, p_e, loc + 1, i_e);
        return node;
    }
}
