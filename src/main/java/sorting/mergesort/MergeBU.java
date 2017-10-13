package sorting.mergesort;

public class MergeBU {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N -sz; lo += sz + sz) {
                MergeSortUtils.merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz -1, N - 1));
            }
        }
    }
}
