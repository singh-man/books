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
        mergeSortEfficient(data, 0, data.length - 1);
    }

    private void mergeSortEfficient(int[] a, int lo, int hi) {
        if (lo >= hi)
            return;

        int length = hi - lo + 1;
        for (int width = 1; width < length; width *= 2) {
            for (int left = lo; left + width <= hi; left += 2 * width) {
                int m = left + width - 1;
                int right = Math.min(left + 2 * width - 1, hi);
                merge(a, left, m, right);
            }
        }
    }

    private void merge(int[] a, int lo, int m, int hi) {
        int[] b = new int[m - lo + 1];
        int i = 0;
        int j = lo;

        // copy first half of array a to auxiliary array b
        while (j <= m)
            b[i++] = a[j++];

        i = 0;
        int k = lo;
        int leftLength = b.length;

        // copy back next-greatest element at each time
        while (i < leftLength && j <= hi)
            if (b[i] <= a[j])
                a[k++] = b[i++];
            else
                a[k++] = a[j++];

        // copy back remaining elements of first half (if any)
        while (i < leftLength)
            a[k++] = b[i++];
    }

    @Test
    public void test() {
        run(new MergeSortEfficientTest());
    }
}
