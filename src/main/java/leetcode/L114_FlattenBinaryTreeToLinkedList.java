package leetcode;

import leetcode.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        if (root == null || (root.left == null && root.right == null))  return;
//        flatten(root.left);
//        flatten(root.right);
//
//        if (root.left == null) return;
//        TreeNode p = root.left;
//        while (p.right != null)  p = p.right;
//        p.right = root.right;
//        root.right = null;
        List<TreeNode> list = new ArrayList<>();
        preTravel(root, list);
        TreeNode node;
        for (int i = 1;i<list.size();i++) {
            node = list.get(i-1);
            node.left = null;
            node.right = list.get(i);
        }
    }

    private void preTravel(TreeNode node, List<TreeNode> list) {
        if (node == null) return;
        list.add(node);
        preTravel(node.left, list);
        preTravel(node.right, list);
    }



}
