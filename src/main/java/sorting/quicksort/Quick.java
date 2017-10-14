package sorting.quicksort;

import static sorting.elementary.SortingUtils.*;

public class Quick {

    public static void sort(Comparable[] a) {
        // 此处可以将数组顺序打乱，虽需要一些时间，但可能提升效率
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi); // 调整顺序，使a[j]左侧均小于它，右侧元素均大于它
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i , j);
        }
        exch(a, lo, j);
        return j;
    }
}
