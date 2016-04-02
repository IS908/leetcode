package leetcode;

import leetcode.Utils.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p/>
 * Created by kevin on 2016/4/2.
 */
public class L108_ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums, low, mid - 1);
        node.right = buildTree(nums, mid + 1, high);
        return node;
    }
}
