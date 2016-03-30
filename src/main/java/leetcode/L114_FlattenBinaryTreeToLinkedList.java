package leetcode;

import leetcode.Utils.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * <p/>
 * For example,
 * Given
 * <p/>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * <p/>
 * Created by kevin on 2016/3/26.
 */
@Deprecated
public class L114_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null)  return;
        flatten(root.left);
        flatten(root.right);

        if (root.left == null) return;
        TreeNode p = root.left;
        while (p.right != null)  p = p.right;
        p.right = root.right;
        root.right = null;
    }

}
