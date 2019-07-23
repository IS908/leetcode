package Algorithm.tree;

import leetcode.Utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 统计和生成所有不同的二叉树
 * <p>
 * 给定一个整数N，如果N<1，代表空树结构，否则代表中序遍历的结果为{1，2，3，…，N}。
 * 请返回可能的二叉树结构有多少。
 * <p>
 * 进阶：N的含义不变，假设可能的二叉树结构有M种，请返回M个二叉树的头节点，每一棵二叉树代表一种可能的结构。
 * @Auther: kun
 * @Date: 2019-07-23 22:27
 */
public class TreeBuilder {

    /**
     * 计算可能的二叉树的数量
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int[] num = new int[n + 1];
        num[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                num[i] += num[j - 1] * num[i - j];
            }
        }
        return num[n];
    }

    /**
     * 生成所有可能的二叉树
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    public List<TreeNode> generate(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (start > end) {
            res.add(null);
        }
        TreeNode head = null;
        for (int i = start; i < end + 1; i++) {
            head = new TreeNode(i);
            List<TreeNode> lSubs = generate(start, i - 1);
            List<TreeNode> rSubs = generate(i + 1, end);
            for (TreeNode l : lSubs) {
                for (TreeNode r : rSubs) {
                    head.left = l;
                    head.right = r;
                    res.add(cloneTree(head));
                }
            }
        }
        return res;
    }

    public TreeNode cloneTree(TreeNode head) {
        if (head == null) {
            return null;
        }
        TreeNode res = new TreeNode(head.val);
        res.left = cloneTree(head.left);
        res.right = cloneTree(head.right);
        return res;
    }

}
