package searching.symboltable;

/**
 * 顺序查找(基于无序链表)
 */
public class SequentialSearchST<Key, Value> {
    private Node first;

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
    }

    public int size() {
        int i = 0;
        for (Node x = first; x != null; x = x.next) {
            i++;
        }
        return i;
    }

    public Key[] keys() {
        Key[] keys = (Key[]) new Object[size()];
        int i = 0;
        for (Node x = first; x != null; x = x.next) {
            keys[i++] = x.key;
        }
        return keys;
    }

    public void delete(Key key) {
        if (first == null || key == null) {
            return;
        }
        if (first.key.equals(key)) {
            first = first.next;
        }
        Node temp = first;
        while (temp.next != null && !temp.next.key.equals(key)) {
            temp = temp.next;
        }
        // 查找无此元素
        if (temp.next == null) {
            return;
        }
        // 删除
        temp.next = temp.next.next;
    }
}
