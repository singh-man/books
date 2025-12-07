package sort;

import org.junit.jupiter.api.Test;

/**
 * Created by M.Singh on 07/02/2018.
 * <p>
 * Straightforward variant of function merge
 * 1. copy array a into auxiliary array b (i and j are iterator)
 * 2. repeat while i<=mid and j<=high
 * copy minimum of b[i] and b[j] to a[k]
 * 3. copy back rest of first half of b (if necessary)
 */
public class MergeSortStraightForwardTest implements ISort {

    @Override
    public void sort(int[] data) throws Exception {
        mergeSortStraightForward(data, 0, 2, 3);
    }

    // Straightforward variant
    public void mergeSortStraightForward(int[] a, int lo, int m, int hi) {
        int i, j, k;
        int[] b = new int[a.length];

        // copy both halves of a to auxiliary array b
        for (i = lo; i <= hi; i++)
            b[i] = a[i];

        i = lo;
        j = m + 1;
        k = lo;
        // copy back next-greatest element at each time
        while (i <= m && j <= hi)
            if (b[i] <= b[j])
                a[k++] = b[i++];
            else
                a[k++] = b[j++];

        // copy back remaining elements of first half (if any)
        while (i <= m)
            a[k++] = b[i++];
    }

    @Test
    public void test() {
        run(new MergeSortStraightForwardTest());
    }
}
