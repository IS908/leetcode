package JavaBasicKnowledge;

/**
 * 二叉查找树的操作类
 * Created by kevin on 2016/3/16.
 */
public class BinarySearchTree<T extends Comparable<? super T>> {
    private static class BinaryNode<T> {
        public BinaryNode(T element) {
            this(element, null, null);
        }

        public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;
    }

    private BinaryNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean contains(T x) {
        return contains(x, root);
    }

    public T findMin() {
        return findMin(this.root);
    }

    public T findMax() {
        return findMax(this.root);
    }

    public void insert(T x) {
        insert(x, this.root);
    }

    public T remove(T x) {
        return remove(x, this.root);
    }

    public void printTree() {
        if (isEmpty()) {
            System.out.println("Empty tree!");
        } else {
            printTree(root);
        }
    }

    private void printTree(BinaryNode<T> root) {

    }

    private T remove(T x, BinaryNode<T> t) {
        if (root == null) return null;
        BinaryNode<T> parent = t;
        BinaryNode<T> cur = t;
        boolean isLeftChild = false;
        // 找到给节点及其父节点
        while (t.element.compareTo(x) != 0) {
            if (t.element.compareTo(x) > 0) {
                parent = t;
                t = t.left;
                isLeftChild = true;
            } else {
                parent = t;
                t = t.right;
                isLeftChild = false;
            }
            if (t == null) return null;
        }
        // 执行删除操作
        // 被删除的节点是叶子节点
        if (t.left == null && t.right == null) {
            if (isLeftChild) parent.left = null;
            else parent.right = null;
            return t.element;
        }
        // 被删除的节点只有左子树
        if (t.right == null) {
            if (isLeftChild) parent.left = t.left;
            else parent.right = t.left;
            return t.element;
        }
        // 被删除的节点只有右子树
        if (t.left == null) {
            if (isLeftChild) parent.left = t.right;
            else parent.right = t.right;
            return t.element;
        }
        // 被删除的节点既有左子树，又有右子树
        BinaryNode<T> tmp = t.right;
        if (isLeftChild) {// 目标节点为其父节点的左子树
            // 目标节点的右子树的左子树为空
            if (tmp.left == null) {
                parent.left = tmp;
                tmp.left = t.left;
            }
            // 目标节点的右子树的左子树非空
            while (tmp.left.left != null) tmp = tmp.left;
            parent.left = tmp.left;
            tmp.left = tmp.left.right;
            parent.left.left = t.left;
        } else {// 目标节点为其父节点的右子树
            // 目标节点的右子树的左子树为空
            if (tmp.left == null) {
                parent.right = tmp;
                tmp.left = t.left;
            }
            // 目标节点的右子树的左子树非空
            while (tmp.left.left != null) tmp = tmp.left;
            parent.right = tmp.left;
            tmp.left = tmp.left.right;
            parent.right.left = t.left;
        }
        return t.element;
    }

    private boolean insert(T x, BinaryNode<T> t) {
        if (t == null) {
            root = new BinaryNode<T>(x, null, null);
            return true;
        }
        while (t != null) {
            if (t.element.compareTo(x) < 0) {
                if (t.left == null) {
                    t.left = new BinaryNode<T>(x, null, null);
                    return true;
                }
                t = t.left;
            } else if (t.element.compareTo(x) > 0) {
                if (t.right == null) {
                    t.right = new BinaryNode<T>(x, null, null);
                    return true;
                }
                t = t.right;
            } else {
                return false;
            }
        }
        return false;
    }

    private T findMax(BinaryNode<T> t) {
        if (t != null)
            while (t.right != null) t = t.right;
        return t.element;
    }

    private T findMin(BinaryNode<T> t) {
        if (t != null)
            while (t.left != null) t = t.left;
        return t.element;
    }

    private boolean contains(T x, BinaryNode<T> t) {
        while (t != null) {
            if (t.element.compareTo(x) == 0) return true;
            t = t.element.compareTo(x) < 0 ? t.right : t.left;
        }
        return false;
    }
}
