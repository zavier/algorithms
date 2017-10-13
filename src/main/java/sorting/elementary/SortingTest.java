package sorting.elementary;

import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class SortingTest {

    private String[] s = "SORTEXAMPLE".split("");

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

}
