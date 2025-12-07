import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class ArraySubsetTest {

    int get_bit(int num, int bit) {
        int temp = (1 << bit);
        temp = temp & num;
        if (temp == 0) {
            return 0;
        }
        return 1;
    }

    void get_all_subsets(List<Integer> v, List<HashSet<Integer>> sets) {
        int subsets_count = (int) (Math.pow((double) 2, (double) v.size()));
        for (int i = 0; i < subsets_count; ++i) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < v.size(); ++j) {
                if (get_bit(i, j) == 1) {
                    int x = v.get(j);
                    set.add(x);
                }
            }
            sets.add(set);
        }
    }

    @Test
    public void myTest() {
        Integer[] myints = new Integer[]{2, 4, 1};
        List<Integer> v = new ArrayList<>();
        for (Integer i : myints) {
            v.add(i);
        }
        List<HashSet<Integer>> subsets = new ArrayList<>();

        get_all_subsets(v, subsets);

        System.out.println("****Total*****" + subsets.size());
        for (int i = 0; i < subsets.size(); ++i) {
            System.out.print("{");
            for (Integer it : subsets.get(i)) {
                System.out.print(it + ", ");
            }
            System.out.println("}");
        }
        System.out.println("****Total*****" + subsets.size());
    }

    @Test
    public void test() {
        IntStream.range(0, 8).forEach(e -> System.out.println(Integer.toBinaryString(e)));
    }
}
