package slidingWindow;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
 * Output: 3 3 4 5 5 5 6
 * Explanation:
 * Maximum of 1, 2, 3 is 3
 * Maximum of 2, 3, 1 is 3
 * ......
 */
public class ArrayMaxOfSubArrTest {

    private void arrBruteForce(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            int[] tmp = new int[k];
            int x = 0;
            int till = arr.length > k + i ? k + i : arr.length - 1;
            for (int j = i; j < till; j++) {
                tmp[x] = arr[j];
                x++;
            }
            Arrays.sort(tmp);
            System.out.print(tmp[k - 1] + " ");
        }
    }

    @Test
    public void testBruteForce() {
        System.out.println();
        int k = 3;
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        arrBruteForce(arr, k);
        System.out.println();
        arr = new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6, 11, 5, 6, 3, 17, 19, 21, 5, 6, 8, 9};
        arrBruteForce(arr, k);
    }

    private void arrList(int[] arr, int k) {
        List<Integer> queue = new LinkedList<>();
        int max;
        for (int i = 0; i < arr.length; i++) {
            if (queue.size() == k) {
                max = queue.stream().sorted().collect(Collectors.toList()).get(k - 1);
                System.out.print(max + " ");
                queue.remove(0);
            }
            queue.add(arr[i]);
        }
        System.out.print(queue.stream().sorted().collect(Collectors.toList()).get(k - 1) + " ");
    }

    @Test
    public void testList() {
        System.out.println();
        int k = 3;
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        arrList(arr, k);
        System.out.println();
        arr = new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6, 11, 5, 6, 3, 17, 19, 21, 5, 6, 8, 9};
        arrList(arr, k);
    }

    private void arrQueue(int[] arr, int k) {
        Deque<Integer> queue = new LinkedList<>();
        // Working on first k set find max and set it to the queue
        for (int i = 0; i < k; i++) {
            if (queue.peekLast() != null && queue.peekLast() < arr[i])
                queue.pollLast();
            queue.addLast(arr[i]);
        }
        // for the rest if the new value is greater add to queue or else re-enter the last value in queue.
        for (int i = k; i < arr.length; i++) {
            if (queue.peekLast() < arr[i]) {
                queue.addLast(arr[i]);
            } else if (queue.peekLast() >= arr[i]) {
                queue.addLast(queue.peekLast());
            }
        }
        queue.forEach(e -> System.out.print(e + " "));
    }

    @Test
    public void testQueue() {
        System.out.println();
        int k = 3;
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        arrQueue(arr, k);
        System.out.println();
        arr = new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6, 11, 5, 6, 3, 17, 19, 21, 5, 6, 8, 9};
        arrQueue(arr, k);
    }
}