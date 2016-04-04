package leetcode;

import JavaBasicKnowledge.AbstractClassAndInterface.InterfaceDemo;
import leetcode.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p/>
 * For example:
 * Given the below binary tree and sum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p/>
 * Created by kevin on 2016/4/2.
 */
public class L113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        List<Integer> list = new ArrayList<>();
        getPathSum(root, sum, 0, list, lists);
        return lists;
    }

    /**
     * 注意new ArrayList<>(list);是创建ArrayList并将list中的元素复制到新创建的ArrayList中
     * @param node
     * @param sum
     * @param cur
     * @param list
     * @param lists
     */
    private void getPathSum(TreeNode node, int sum, int cur, List<Integer> list, List<List<Integer>> lists) {
        cur += node.val;
        list.add(node.val);
        if (node.left == null && node.right == null && sum == cur) {
            List<Integer> tmp = new ArrayList<>(list);
            lists.add(tmp);
        }
        if (node.left != null) {
            getPathSum(node.left, sum, cur, list, lists);
            list.remove(list.size() - 1);
        }
        if (node.right != null) {
            getPathSum(node.right, sum, cur, list, lists);
            list.remove(list.size() - 1);
        }
    }
}
