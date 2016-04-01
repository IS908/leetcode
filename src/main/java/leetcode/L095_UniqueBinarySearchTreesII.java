package leetcode;

import leetcode.Utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * <p/>
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * <p/>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p/>
 * Created by kevin on 2016/4/1.
 */
@Deprecated
public class L095_UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new LinkedList<>();

        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTrees(start, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }

        return list;
    }
}
