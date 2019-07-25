package Algorithm.tree;

import leetcode.Utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description: 在二叉树中找到两个节点的最近公共祖先
 * @Auther: kun
 * @Date: 2019-07-23 11:35
 */
public class LowestAncestor {

    public TreeNode lowestAncestor(TreeNode head, TreeNode o1, TreeNode o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        TreeNode left = lowestAncestor(head.left, o1, o2);
        TreeNode right = lowestAncestor(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }

    /**
     * 建立二叉树中每个节点对应的父节点信息，是一张哈希表。
     */
    public class Record1 {
        private HashMap<TreeNode, TreeNode> map;

        public Record1(TreeNode head) {
            map = new HashMap<>();
            if (head != null) {
                map.put(head, null);
            }
            setMap(head);
        }

        private void setMap(TreeNode head) {
            if (head == null) {
                return;
            }
            if (head.left != null) {
                map.put(head.left, head);
            }
            if (head.right != null) {
                map.put(head.right, head);
            }
            setMap(head.left);
            setMap(head.right);
        }

        public TreeNode query(TreeNode o1, TreeNode o2) {
            HashSet<TreeNode> path = new HashSet<>();
            while (map.containsKey(o1)) {
                path.add(o1);
                o1 = map.get(o1);
            }
            while (!path.contains(o2)) {
                o2 = map.get(o2);
            }
            return o2;
        }
    }

    /**
     * 直接建立任意两个节点之间的最近公共祖先记录，便于以后查询时直接查。
     * <p>
     * 1. 对二叉树中的每棵子树（一共N棵）都进行步骤2。
     * 2. 假设子树的头节点为h，h所有的后代节点和h节点的最近公共祖先都是h，记录下来。
     * h左子树的每个节点和h右子树的每个节点的最近公共祖先都是h，记录下来。
     * <p>
     * 为了保证记录不重复，设计一种好的实现方式是这种结构实现的重点。
     */
    // TODO
    public class Record2 {
        private HashMap<TreeNode, HashMap<TreeNode, TreeNode>> map;

        public Record2(TreeNode head) {
            map = new HashMap<>();
            initMap(head);
            setMap(head);
        }

        private void initMap(TreeNode head) {
            if (head == null) {
                return;
            }
            map.put(head, new HashMap<>());
            initMap(head.left);
            initMap(head.right);
        }

        private void setMap(TreeNode head) {
            if (head == null) {
                return;
            }
            headRecord(head.left, head);
            headRecord(head.right, head);
            subRecord(head);
            setMap(head.left);
            setMap(head.right);
        }

        private void headRecord(TreeNode n, TreeNode h) {
            if (n == null) {
                return;
            }
            map.get(n).put(h, h);
            headRecord(n.left, h);
            headRecord(n.right, h);
        }

        private void subRecord(TreeNode head) {
            if (head == null) {
                return;
            }
            preLeft(head.left, head.right, head);
            subRecord(head.left);
            subRecord(head.right);
        }

        private void preLeft(TreeNode l, TreeNode r, TreeNode h) {
            if (l == null) {
                return;
            }
            preRight(l, r, h);
            preLeft(l.left, r, h);
            preLeft(l.right, r, h);
        }

        private void preRight(TreeNode l, TreeNode r, TreeNode h) {
            if (r == null) {
                return;
            }
            map.get(l).put(r, h);
            preRight(l, r.left, h);
            preRight(l, r.right, h);
        }

        public TreeNode query(TreeNode o1, TreeNode o2) {
            if (o1 == o2) {
                return o1;
            }
            if (map.containsKey(o1)) {
                return map.get(o1).get(o2);
            }
            if (map.containsKey(o2)) {
                return map.get(o2).get(o1);
            }
            return null;
        }
    }

}
