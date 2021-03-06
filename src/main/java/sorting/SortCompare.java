package sorting;

import java.util.Random;
import sorting.elementary.Insertion;
import sorting.elementary.Selection;
import sorting.elementary.Shell;
import sorting.elementary.SortingUtils;
import sorting.mergesort.Merge;
import sorting.quicksort.Quick;
import sorting.priorityqueues.Heap;

public class SortCompare {

    private static Random random = new Random();

    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) {
            Insertion.sort(a);
        }
        if (alg.equals("Selection")) {
            Selection.sort(a);
        }
        if (alg.equals("Shell")) {
            Shell.sort(a);
        }
        if (alg.equals("Merge")) {
            Merge.sort(a);
        }
        if (alg.equals("Quick")) {
            Quick.sort(a);
        }
        if (alg.equals("Heap")) {
            Heap.sort(a);
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = random.nextDouble();
            }
//            System.out.println(Arrays.toString(a));
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = "Insertion";
        String alg2 = "Selection";
        String alg3 = "Shell";
        String alg4 = "Merge";
        String alg5 = "Quick";
        String alg6 = "Heap";
        int N = 1000;
        int T = 100;
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        double t3 = timeRandomInput(alg3, N, T);
        double t4 = timeRandomInput(alg4, N, T);
        double t5 = timeRandomInput(alg5, N, T);
        double t6 = timeRandomInput(alg6, N, T);

        System.out.println(alg1 + " time is :" + t1);
        System.out.println(alg2 + " time is :" + t2);
        System.out.println(alg3 + " time is :" + t3);
        System.out.println(alg4 + " time is :" + t4);
        System.out.println(alg5 + " time is :" + t5);
        System.out.println(alg6 + " time is :" + t6);
    }

}
