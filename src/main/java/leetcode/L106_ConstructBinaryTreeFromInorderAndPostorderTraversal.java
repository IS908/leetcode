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

        return null;
    }
}
