package sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by M.Singh on 07/02/2018.
 * Bubble Sort is the simplest sorting algorithm that works by
 * repeatedly swapping the adjacent elements if they are in wrong order.
 */
public class Bogo_Bucket_Bubble_Insertion_SelectionTest implements ISort {

    /**
     * Created by M.Singh on 07/02/2018.
     * BogoSort also known as permutation sort, stupid sort, slow sort, shotgun sort or monkey sort
     * is a particularly ineffective algorithm based on generate and test paradigm.
     * The algorithm successively generates permutations of its input until it finds one that is sorted.(Wiki)
     * For example, if bogosort is used to sort a deck of cards,
     * it would consist of checking if the deck were in order,
     * and if it were not, one would throw the deck into the air,
     * pick the cards up at random, and repeat the process until the deck is sorted.
     */
    @Test
    public void bogoSort() {
        int[] data = new int[]{0, 5, 6, 3, 7, 0, 3, 7, 8, 9, 2, 5};
        final Random generator = new Random();
        while (!isSorted(data)) {
            for (int i = 0; i < data.length; i++) {
                int randomPosition = generator.nextInt(data.length);
                swap(data, i, randomPosition);
            }
        }
        Arrays.stream(data).forEach(System.out::println);
    }

    /**
     * bucketSort(arr[], n)
     * 1) Create n empty buckets (Or lists).
     * 2) Do following for every array element arr[i].
     * .......a) Insert arr[i] into bucket[n*array[i]]
     * 3) Sort individual buckets using insertion sort.
     * 4) Concatenate all sorted buckets.
     */
    @Test
    public void sort() throws Exception {
        int[] data = new int[]{0, 5, 6, 3, 7, 0, 3, 7, 8, 9, 2, 5};
        for (int i = (data.length - 1); i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (data[j - 1] > data[j]) {
                    swap(data, j - 1, j);
                }
            }
        }
    }

    /**
     * Created by M.Singh on 07/02/2018.
     * Bubble Sort is the simplest sorting algorithm that works by
     * repeatedly swapping the adjacent elements if they are in wrong order.
     */
    @Test
    public void bubbleSort() {
        int[] data = new int[]{0, 5, 6, 3, 7, 0, 3, 7, 8, 9, 2, 5};
        for (int k = 0; k < data.length - 1; k++) {
            boolean isSorted = true;

            for (int i = 1; i < data.length - k; i++) {
                if (data[i] < data[i - 1]) {
                    swap(data, i, i - 1);

                    isSorted = false;
                }
            }
            if (isSorted)
                break;
        }
        Arrays.stream(data).forEach(System.out::println);
    }

    /**
     * Insertion sort is similar to bubble sort, but is more efficient as it
     * reduces element comparisons somewhat with each pass. An element is compared
     * to all the prior elements until a lesser element is found. In other words, if
     * an element contains a value less than all the previous elements, it compares
     * the element to all the previous elements before going on to the next comparison.
     * Although this algorithm is more efficient than the Bubble sort, it is still
     * inefficient compared to many other sort algorithms since it, and bubble sort,
     * move elements only one position at a time. However, insertion sort is a good
     * choice for small lists (about 30 elements or fewer), and for nearly-sorted lists.
     */
    @Test
    public void insertionSort() {
        int[] data = new int[]{0, 5, 6, 3, 7, 0, 3, 7, 8, 9, 2, 5};
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j] < data[j - 1]) {
                    swap(data, j, j - 1);
                }
            }
        }
        Arrays.stream(data).forEach(System.out::println);
    }

    /**
     * Selection sort is a sorting algorithm, a comparison sort that works as follows:
     * 1. find the minimum value in the list
     * 2. swap it with the value in the first position
     * 3. sort the remainder of the list (excluding the first value)
     * It is probably the most intuitive sort algorithm to invent.
     */
    @Test
    public void selectionSort() {
        int[] data = new int[]{0, 5, 6, 3, 7, 0, 3, 7, 8, 9, 2, 5};
        for (int i = 0; i < data.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < data.length; j++)
                if (data[j] < data[min])
                    min = j;
            swap(data, i, min);
        }
        Arrays.stream(data).forEach(System.out::println);
    }
}
