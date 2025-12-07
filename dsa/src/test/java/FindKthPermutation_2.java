import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindKthPermutation_2 {

    int factorial(int n) {
        if (n ==0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    String findKthPermutation(int n, int k, String str, List<Integer> list) {
        int blockSize = factorial(n - 1); // no. of elements in each block
        int idx = k / blockSize; // represents value in the list

        // very important boundary check because wer are starting from 0 and this is the boundary value.
        if (k % blockSize == 0) idx--;

        if(n == 1)  {
            str += list.remove(0);
        } else {
            str += list.remove(idx);
            k = k - blockSize * idx; // calculate new k value for upcoming block
            str = findKthPermutation(n - 1, k, str, list);
        }
        return str;
    }

    @Test
    public void test() {
        int n = 3, k = 5;
        List<Integer> collect = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        String kth_perm_seq = findKthPermutation(n, k, "", collect);
        System.out.print(kth_perm_seq);
    }
}