package searching.symboltable;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找(基于有序数组)
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 小于key的键的数量
     * @param key
     * @return
     */
    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public void put(Key key, Value val) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        for (int j = N; j > i; i++) {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public void delete(Key key) {
        int i = rank(key);
        if (i >= N || keys[i].compareTo(key) != 0) {
            return;
        }
        i++;
        for (; i < N - 1; i++) {
            keys[i] = keys[i+1];
            vals[i] = vals[i+1];
        }
        keys[i] = null;
        vals[i] = null;
        N--;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N-1];
    }

    public Key select(int k) {
        return keys[k];
    }

    /**
     * 大于等于key的最小值
     * @param key
     * @return
     */
    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    /**
     * 小于等于key的最大值
     * @param key
     * @return
     */
    public Key floor(Key key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return keys[i];
        }
        return keys[i-1];
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        List<Key> list = new ArrayList<>();
        for (int i = rank(lo); i < rank(hi); i++) {
            list.add(keys[i]);
        }
        if (contains(hi)) {
            list.add(keys[rank(hi)]);
        }
        return list;
    }

    private boolean contains(Key key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return true;
        }
        return false;
    }
}
