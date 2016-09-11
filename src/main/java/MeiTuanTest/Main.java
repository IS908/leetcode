package MeiTuanTest;

import java.util.*;

/**
 * 遗憾
 * <p>
 * Created by kevin on 16-9-11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, TreeNode> map = new HashMap<>();
        String line = sc.nextLine();
        String[] strs = line.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        map.put(root.val, root);
        List<TreeNode> list = root.children;
        for (int i = 1; i < strs.length; i++) {
            TreeNode node = new TreeNode(Integer.valueOf(strs[i]));
            list.add(node);
            map.put(node.val, node);
        }
        while (sc.hasNextLine()) {
            String li = sc.nextLine();
            String[] strss = li.split(" ");
            TreeNode node = map.get(Integer.valueOf(strss[0]));

            List<TreeNode> children = node.children;
            for (int i = 1; i < strss.length; i++) {
                TreeNode tmp = new TreeNode(Integer.valueOf(strss[i]));
                children.add(tmp);
                map.put(tmp.val, tmp);
            }
        }
        // 构造树完成

        // 开始树的遍历
        print(root);
    }

    private static void print(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val); // 将结果保留
            List<TreeNode> children = node.children;
            for (TreeNode tmp : children) {
                queue.offer(tmp);
            }
        }
        for (Integer tmp : list) {
            System.out.print(tmp + " ");
        }
    }
}

class TreeNode {
    public TreeNode(int val) {
        this.val = val;
    }

    int val;
    List<TreeNode> children = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        if (val != treeNode.val) return false;
        return true;

    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + (children != null ? children.hashCode() : 0);
        return result;
    }
}
