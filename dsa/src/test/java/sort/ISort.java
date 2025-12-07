package sort;

import org.junit.jupiter.api.Assertions;
import utils.timer.StopWatch;

import java.util.Arrays;

/**
 * Created by M.Singh on 07/02/2018.
 */
public interface ISort {

    int[] data = new int[]{0, 5, 6, 3, 7, 0, 3, 7, 8, 9, 2, 5};

    default void sort(int[] data) throws Exception{};

    default <T extends Comparable> T[] sort(T[] data) throws Exception {
        return data;
    }

    default void run(ISort sort) {
        try {
            System.out.println("Original: " + Arrays.toString(data));

            StopWatch sw = new StopWatch().start();
            sort.sort(data);
            sw.log(sort.getClass().getName() + " : Sorting done");
            sw.stop();

            System.out.println("Sorted: " + Arrays.toString(data));

            sw.printConsole();

            Assertions.assertTrue(isSorted(data));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    default void swap(int[] data, int i, int j) {
        int tempVariable = data[i];
        data[i] = data[j];
        data[j] = tempVariable;
    }

    default boolean isSorted(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] > data[i + 1])
                return false;
        }
        return true;
    }

    default <T extends Comparable> boolean isSorted(T[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i].compareTo(data[i + 1]) > 0)
                return false;
        }
        return true;
    }
}