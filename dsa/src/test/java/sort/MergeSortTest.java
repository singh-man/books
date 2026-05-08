package sort;

import org.junit.jupiter.api.Test;

/**
 * Created by M.Singh on 07/02/2018.
 * <p>
 * In computer science, merge sort or mergesort is a sorting algorithm for
 * rearranging lists (or any other data structure that can only be accessed
 * sequentially, e.g. file streams) into a specified order. It is a particularly
 * good example of the divide and conquer algorithmic paradigm. It is a
 * comparison sort. Conceptually, merge sort works as follows: 1.Divide the
 * unsorted list into two sublists of about half the size 2.ISort each of the
 * two sublists 3.Merge the two sorted sublists back into one sorted list. The
 * algorithm was invented by John von Neumann in 1945. *
 */
public class MergeSortTest implements ISort {

    @Override
    public void sort(int[] data) throws Exception {
        if (data == null || data.length < 2) {
            return;
        }
        int[] aux = new int[data.length];
        mergeSort(data, aux, 0, data.length - 1);
    }

    private void mergeSort(int[] array, int[] aux, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(array, aux, left, mid);
        mergeSort(array, aux, mid + 1, right);

        // Skip merge when both halves are already ordered.
        if (array[mid] <= array[mid + 1]) {
            return;
        }

        merge(array, aux, left, mid, right);
    }

    private void merge(int[] array, int[] aux, int left, int mid, int right) {
        System.arraycopy(array, left, aux, left, right - left + 1);

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (aux[i] <= aux[j]) {
                array[k++] = aux[i++];
            } else {
                array[k++] = aux[j++];
            }
        }

        while (i <= mid) {
            array[k++] = aux[i++];
        }

        while (j <= right) {
            array[k++] = aux[j++];
        }
    }

    @Test
    public void test() {
        run(new MergeSortTest());
    }
}