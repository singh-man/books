package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by M.Singh on 07/02/2018.
 * <p>
 * Technique based on keys between a specific range.
 * It works by counting the number of objects having distinct key values (kind of hashing).
 * Then doing some arithmetic to calculate the position of each object in the output sequence.
 * <p>
 * This is non-comparative sorting technique
 */
public class CountingSortTest implements ISort {

    @Override
    public void sort(int[] data) throws Exception {
        Map<Integer, Integer> frequency = new TreeMap<>();
        for (int i : data) {
            if (frequency.computeIfPresent(i, (k, v) -> v + 1) == null)
                frequency.put(i, 1);
        }
        int j = 0;
        for (Map.Entry<Integer, Integer> e : frequency.entrySet()) {
            for (int i = 0; i < e.getValue(); i++) {
                data[j] = e.getKey();
                j++;
            }
        }
    }

    private <T extends Comparable<T>> void CS(T[] array) {
        Map<T, Integer> frequency = new TreeMap<>();
        for (T t : array) {
            if (frequency.containsKey(t)) {
                frequency.put(t, frequency.get(t) + 1);
            } else
                frequency.put(t, 1);
        }
        int j = 0;
        for (Map.Entry<T, Integer> e : frequency.entrySet()) {
            for (int i = 0; i < e.getValue(); i++) {
                array[j] = e.getKey();
                j++;
            }
        }
    }

    @Test
    public void test() {
        run(new CountingSortTest());
        Integer[] data = {0, 5, 6, 3, 7, 0, 3, 7, 8, 9, 2, 5};
        CS(data);
        System.out.println("Sorted: " + Arrays.toString(data));
        Assertions.assertTrue(isSorted(data));
    }
}