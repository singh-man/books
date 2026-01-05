import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Decorator {

    private Function<String, String>[] getT() {
        Function<String, String> decorate_1 = s -> s + " 1";
        Function<String, String> decorate_2 = s -> s + " 2";
        Function<String, String> decorate_3 = s -> s + " 3";
        return new Function[] {decorate_1, decorate_2, decorate_3};
    }

    @Test
    public void pureFunction_newObjectOnEveryOperation_0() {
        Function<String, String> decorate_1 = s -> s + " 1";
        Function<String, String> decorate_2 = s -> s + " 2";
        Function<String, String> decorate_3 = s -> s + " 3";

        Function<String, String> finalFunc = e -> e; //or Function.identity();

        for (var f : List.of(decorate_1, decorate_2, decorate_3)) {
            finalFunc = finalFunc.andThen(f);
        }
        Assertions.assertEquals("me 1 2 3",
                finalFunc.apply("me"));
    }

    @Test
    public void pureFunction_newObjectOnEveryOperation_1() {
        Function<String, String> decorate_1 = s -> s + " 1";
        Function<String, String> decorate_2 = s -> s + " 2";
        Function<String, String> decorate_3 = s -> s + " 3";

        Optional<Function<String, String>> reduce = Stream.of(decorate_1, decorate_2, decorate_3)
                .reduce((f1, f2) -> f1.andThen(f2));

        Assertions.assertEquals("me 1 2 3", reduce.get().apply("me"));
    }

    private Function<String, String> chainAll(Function<String, String>... func) {
        return Stream.of(func)
                .reduce((f1, f2) -> f1.andThen(f2)).get();
    }

    @Test
    public void pureFunction_newObjectOnEveryOperation_2() {
        Function<String, String> decorate_1 = s -> s + " 1";
        Function<String, String> decorate_2 = s -> s + " 2";
        Function<String, String> decorate_3 = s -> s + " 3";

        Function<String, String> decorated = chainAll(decorate_1, decorate_2, decorate_3);

        Assertions.assertEquals("me 1 2 3", decorated.apply("me"));
    }

    @Test
    public void pureFunction_newObjectOnEveryOperation_3() {
        Function<String, String> decorate_1 = s -> s + " 1";
        Function<String, String> decorate_2 = s -> s + " 2";
        Function<String, String> decorate_3 = s -> s + " 3";

        Function<String, String> decorated = decorate_1
                .andThen(decorate_2)
                .andThen(decorate_3);

        Assertions.assertEquals("me 1 2 3", decorated.apply("me"));
    }

    @Test
    public void pureFunction_withSubClassStyle() {
        interface Transform extends Function<String, String> {
           default String transform(String s) {
              return this.apply(s);
           }
        }
        class MyTransform implements Transform {
            @Override
            public String apply(String s) {
                return s + " : " + System.currentTimeMillis();
            }
        }
        var s = "me";
        String after = new MyTransform()
                .andThen(new MyTransform()) // MyTransform is a sub-class of Function so it works here
                .andThen(new MyTransform()) // apply.. called internally by andThen
                .apply(s); // Remember this will come handy
        Assertions.assertTrue(after.contains(":"));
        System.out.println(after);
    }
    @Test
    public void impureFunction_Consumer_mutableObject_objModifiedInEachOperation() {
        class A {
            A(String s) {
                this.s = s;
            }
            String s;
        }

        Consumer<A> dec1 = a -> a.s += " Hello";
        Consumer<A> dec2 = a -> a.s += " World";
        Consumer<A> dec3 = a -> a.s += " More";

        Consumer<A> finalDec = dec1
                .andThen(dec2)
                .andThen(dec3);

        var test = new A("Test"); // Object will be modified by decorator chaining
        System.out.println("Before decorator = " + test.s);
        Assertions.assertEquals("Test", test.s);
        finalDec.accept(test); // Consumer returns void
        System.out.println("After decorator = " + test.s);
        Assertions.assertEquals("Test Hello World More", test.s);
    }
}