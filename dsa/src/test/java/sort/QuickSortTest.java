package sort;

import org.junit.jupiter.api.Test;

/**
 * Created by M.Singh on 07/02/2018.
 * <p>
 * Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot. There are many different versions of quickSort that pick pivot in different ways.
 * <p>
 * Always pick first element as pivot.
 * Always pick last element as pivot (implemented below)
 * Pick a random element as pivot.
 * Pick median as pivot.
 * <p>
 * The key process in quickSort is partition().
 * Target of partitions is, given an array and an element x of array as pivot,
 * put x at its correct position in sorted array and put all smaller elements
 * (smaller than x) before x, and put all greater elements (greater than x) after x.
 * All this should be done in linear time.
 */
public class QuickSortTest implements ISort {

    @Override
    public void sort(int[] data) throws Exception {
        quickSort(data, 0, data.length - 1);
    }

    private void quickSort(int[] a, int lowerIndex, int higherIndex) {
        //  lowerIndex is the lower index, hi is the upper index
        //  of the region of array a that is to be sorted
        int i = lowerIndex, j = higherIndex;

        // comparison element x
        int pivot = a[(lowerIndex + higherIndex) / 2];

        //  partition
        do {
            while (a[i] < pivot) i++;
            while (a[j] > pivot) j--;
            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        } while (i <= j);

        //  recursion
        if (lowerIndex < j) quickSort(a, lowerIndex, j);
        if (i < higherIndex) quickSort(a, i, higherIndex);
    }

    @Test
    public void test() {
        run(new QuickSortTest());
    }
}
