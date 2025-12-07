import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Each note calculator function (COR) if it can process will process and then sends to next function (decorator)
 * COR:- early exit i.e. no processing if it can handle
 * Decorator:- works on all till end.
 * <p>
 * Mix UP:- If it can process, *do process* and then move to next
 */
public class ChainOfResp_and_Decorator_Mix {

    static class A {
        int bal, requested;
        int n100, n50, n20, n10, n5;
    }

    interface NoteCalculator extends Function<A, A> {

        @Override
        default A apply(A t) {
            return process(t);
        }

        A process(A t);

//        default A toProceed(A t) {
//            if(t.x < t.reach) return t;
//        }
    }

    @Test
    public void cor_way() {
        NoteCalculator f = a -> a;
        NoteCalculator note100 = a -> {
            int bal = (a.requested - a.bal) / 100;
            a.n100 = bal;
            a.bal += bal * 100;
            return a;
        };
        A modifiable = new A();
        modifiable.bal = 0;
        modifiable.requested = 705;
        List<A> ignorableListInThisCase = Stream.of(note100, getNote50(), getNote20(), getNote10(), getNote5())
                .filter(ff -> modifiable.bal < modifiable.requested)
                .map(ff -> ff.apply(modifiable))
                .toList(); // Pure COR will have findFirst() i.e. map modifies the value and collected list is ignored. Note: list contains n references of same object!!
        assertEquals(modifiable.n100, 7);
        assertEquals(modifiable.n50, 0);
        assertEquals(modifiable.n20, 0);
        assertEquals(modifiable.n10, 0);
        assertEquals(modifiable.n5, 1);
        print(modifiable);
    }

    private static void print(A modifiable) {
        System.out.println(String.format("Amt=%d, %d notes of 100; %d notes of 50; %d notes of 20; %d notes of 10; %d notes of 5",
                modifiable.requested, modifiable.n100, modifiable.n50, modifiable.n20, modifiable.n10, modifiable.n5));
    }

    @Test
    public void decorator() {
        NoteCalculator f = a -> a;
        NoteCalculator note100 = a -> {
            int bal = (a.requested - a.bal) / 100;
            a.n100 = bal;
            a.bal += bal * 100;
            return a;
        };
        A modifiable = new A();
        modifiable.bal = 0;
        modifiable.requested = 500;
        note100
                .andThen(getNote50())
                .andThen(getNote20())
                .andThen(getNote10())
                .andThen(getNote5())
                .apply(modifiable);
        assertEquals(modifiable.n100, 5);
        assertEquals(modifiable.n50, 0);
        assertEquals(modifiable.n20, 0);
        assertEquals(modifiable.n10, 0);
        assertEquals(modifiable.n5, 0);
        print(modifiable);
    }

    private static NoteCalculator getNote5() {
        return a -> {
            int bal = (a.requested - a.bal) / 5;
            a.n5 = bal;
            a.bal += bal * 5;
            return a;
        };
    }

    private static NoteCalculator getNote10() {
        return a -> {
            int bal = (a.requested - a.bal) / 10;
            a.n10 = bal;
            a.bal += bal * 10;
            return a;
        };
    }

    private static NoteCalculator getNote20() {
        return a -> {
            int bal = (a.requested - a.bal) / 20;
            a.n20 = bal;
            a.bal += bal * 20;
            return a;
        };
    }

    private static NoteCalculator getNote50() {
        return a -> {
            int bal = (a.requested - a.bal) / 50;
            a.n50 = bal;
            a.bal += bal * 50;
            return a;
        };
    }
}
