package sorting;

import static org.junit.Assert.*;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import sorting.elementary.Insertion;
import sorting.elementary.Selection;
import sorting.elementary.Shell;
import sorting.elementary.SortingUtils;
import sorting.mergesort.Merge;
import sorting.priorityqueues.Heap;
import sorting.quicksort.Quick;

public class SortingTest {
    private static Random random = new Random();

    private Double[] s;

    private Double[] timeRandomInput(int N) {
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = random.nextDouble();
        }
        return a;
    }

    @Before
    public void setUp() {
        s = timeRandomInput(1000);
    }

    @Test
    public void testSelectionSort() {
        assertFalse(SortingUtils.isSorted(s));
        Selection.sort(s);
        assertTrue(SortingUtils.isSorted(s));
    }

    @Test
    public void testInsertionSort() {
        assertFalse(SortingUtils.isSorted(s));
        Insertion.sort(s);
        assertTrue(SortingUtils.isSorted(s));
    }

    @Test
    public void testShellSort() {
        assertFalse(SortingUtils.isSorted(s));
        Shell.sort(s);
        assertTrue(SortingUtils.isSorted(s));
    }

    @Test
    public void testMegetSort() {
        assertFalse(SortingUtils.isSorted(s));
        Merge.sort(s);
        assertTrue(SortingUtils.isSorted(s));
    }

    @Test
    public void testQuickSort() {
        assertFalse(SortingUtils.isSorted(s));
        Quick.sort(s);
        assertTrue(SortingUtils.isSorted(s));
    }

    /**
     * 堆排序不使用数组中的第0个元素，故重写单元测试
     */
    @Test
    public void testHeapSort() {
        int N = 1000;
        Double[] a = new Double[N];
        for (int i = 1; i < N; i++) {
            a[i] = random.nextDouble();
        }
        assertFalse(isSortedHeap(a));
        Heap.sort(s);
        assertTrue(isSortedHeap(s));
    }

    private static boolean isSortedHeap(Comparable[] a) {
        // 忽略第0个元素
        for (int i = 2; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
                return false;
            }
        }
        return true;
    }
}
