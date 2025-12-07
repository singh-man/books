package sort;

import org.junit.jupiter.api.Test;

/**
 * Created by M.Singh on 07/02/2018.
 * <p>
 * Heapsort is one of the best general-purpose sort algorithms, a comparison sort
 * and part of the selection sort family. Although somewhat slower in practice on
 * most machines than a good implementation of quicksort, it has the advantages of
 * worst-case O(n log n) runtime and being an in-place algorithm. Heapsort is not
 * a stable sort.
 */
public class HeapSortTest implements ISort {

    public void sort(int arr[]) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
//            int temp = arr[0];
//            arr[0] = arr[i];
//            arr[i] = temp;
            swap(arr, 0 , i);

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    private void heapify(int arr[], int n, int i) {
        int largest = i;  // Initialize largest as root
        int l = 2 * i + 1;  // left = 2*i + 1
        int r = 2 * i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    @Test
    public void testHeapSort() throws Exception {
        run(new HeapSortTest());
    }
}
