//package dp;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class Iterator {

    static final List<Integer> list = asList( 1, 2, 3, 4, 5, 6 );

    @Test
    public void test() {
        list.forEach( System.out::println );
    }
}