package sorting.mergesort;

import sorting.elementary.SortingUtils;

public class MergeSortUtils {

    public static Comparable[] aux = new Comparable[0];

    // 为了复用aux的空间,不在每次调用的时候重新创建数组
    public static void initAux(Comparable[] a) {
        if (aux.length > 0 && aux.length >= a.length) {
            // 不需要重新分配空间
        } else {
            aux = new Comparable[a.length];
        }
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        initAux(a);

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (SortingUtils.less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
