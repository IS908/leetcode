package leetcode;

import leetcode.Utils.TreeNode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p/>
 * Created by kevin on 2016/3/31.
 */
public class L106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buileTreeByInPost(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buileTreeByInPost(int[] inorder, int[] postorder, int i_s, int i_e, int p_s, int p_e) {
        if (i_s > i_e) return null;
        int pivot = postorder[p_e];
        int loc = i_s;
        for (; loc < i_e; loc++) {
            if (inorder[loc] == pivot) break;
        }
        int len = loc - i_s;
        TreeNode node = new TreeNode(pivot);
        node.left = buileTreeByInPost(inorder, postorder, i_s, loc - 1, p_s, p_s + len - 1);
        node.right = buileTreeByInPost(inorder, postorder, loc + 1, i_e, p_s + len, p_e - 1);
        return node;
    }
}
