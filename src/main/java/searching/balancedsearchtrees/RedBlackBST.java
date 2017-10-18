package searching.balancedsearchtrees;

public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        Key key;
        Value val;
        Node left;
        Node right;
        int N;
        boolean color;

        public Node(Key key, Value val, int n, boolean color) {
            this.key = key;
            this.val = val;
            N = n;
            this.color = color;
        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null) {
            return new Node(key, val, 1, RED);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, val);
        } else if (cmp > 0) {
            h.right = put(h.right, key, val);
        } else {
            h.val = val;
        }

        // 如果右子节点是红色的而左子节点是黑色的，进行左旋转
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateleft(h);
        }
        // 如果左子节点是红色的且它的左子节点也是红色的，进行又旋转
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        // 如果左右子节点均为红色，进行颜色转换
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }


    public void deleteMin() {
        // TODO 算法（第四版）:290 页
    }

    public void deleteMax() {
        //TODO
    }

    public void delete(Key key) {
        //TODO
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }

    private Node rotateleft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipColors(Node h) {
        h.left.color = BLACK;
        h.right.color = BLACK;
        h.color = RED;
    }
}
