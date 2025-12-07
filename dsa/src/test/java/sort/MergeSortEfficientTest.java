package sort;

import org.junit.jupiter.api.Test;

/**
 * Created by M.Singh on 07/02/2018.
 * <p>
 * Efficient variant of function merge
 * <p>
 * 1. Copy of first half of array a into auxiliary array b
 * 2. Repeat while k<j and j<=high copy minimum of b[i] and a[j] to a[k]
 * 3. copy back rest of first half of b (if necessary)
 */
public class MergeSortEfficientTest implements ISort {
    @Override
    public void sort(int[] data) throws Exception {
        mergeSortEfficient(data, 0, data.length/2 -1, data.length-1);
    }

    /**/

    private void mergeSortEfficient(int[] a, int lo, int m, int hi) {
        int i, j, k;
        int[] b = new int[a.length];
        i = 0;
        j = lo;
        // copy first half of array a to auxiliary array b
        while (j <= m)
            b[i++] = a[j++];

        i = 0;
        k = lo;
        // copy back next-greatest element at each time
        while (k < j && j <= hi)
            if (b[i] <= a[j])
                a[k++] = b[i++];
            else
                a[k++] = a[j++];

        // copy back remaining elements of first half (if any)
        while (k < j)
            a[k++] = b[i++];
    }

    @Test
    public void test() {
        run(new MergeSortEfficientTest());
    }
}
