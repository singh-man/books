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
        mergeSort(data);
    }

    private int[] mergeSort(int array[]) {
        if (array.length > 1) {
            int elementsInA1 = array.length / 2;
            int elementsInA2 = array.length - elementsInA1;
            int arr1[] = new int[elementsInA1];
            int arr2[] = new int[elementsInA2];

            for (int i = 0; i < elementsInA1; i++)
                arr1[i] = array[i];

            for (int i = elementsInA1; i < elementsInA1 + elementsInA2; i++)
                arr2[i - elementsInA1] = array[i];

            arr1 = mergeSort(arr1);
            arr2 = mergeSort(arr2);

            int i = 0, j = 0, k = 0;

            while (arr1.length != j && arr2.length != k) {
                if (arr1[j] <= arr2[k]) {
                    array[i] = arr1[j];
                    i++;
                    j++;
                } else {
                    array[i] = arr2[k];
                    i++;
                    k++;
                }
            }

            while (arr1.length != j) {
                array[i] = arr1[j];
                i++;
                j++;
            }
            while (arr2.length != k) {
                array[i] = arr2[k];
                i++;
                k++;
            }
        }
        return array;
    }

    @Test
    public void test() {
        run(new MergeSortTest());
    }
}