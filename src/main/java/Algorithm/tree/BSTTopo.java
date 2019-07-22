package Algorithm.tree;

import Algorithm.entity.TreeNode;

/**
 * @Description: 找到二叉树中符合搜索二叉树条件的最大拓扑结构
 *
 * @Auther: kun
 * @Date: 2019-07-21 23:04
 */
public class BSTTopo {

    public int bstTopoSize1(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int max = maxTopo(head, head);
        max = Math.max(bstTopoSize1(head.left), max);
        max = Math.max(bstTopoSize1(head.right), max);
        return max;
    }

    public int maxTopo(TreeNode h, TreeNode n) {
        if (h != null && n != null
                && isBSTNode(h, n, n.value)) {
            return maxTopo(h, n.left) + maxTopo(h, n.right) + 1;
        }
        return 0;
    }

    public boolean isBSTNode(TreeNode h, TreeNode n, int value) {
        if (h == null) {
            return false;
        }
        if (h == n) {
            return true;
        }
        return isBSTNode(h.value > value ? h.left : h.right, n, value);
    }


}
