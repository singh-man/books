FP Techniques In JAVA
=====================

### Functor

A Functor is a functional programming concept that represents a type that can be mapped over, i.e., you can apply a function to the values inside the type while preserving the structure of the type.

```java
// Functor interface with a "map" method
interface Functor<T> {
    <R> Functor<R> map(Function<T, R> function);
}
```

java example : `Optional<U> map(Function<? super T, ? extends U> mapper)`

> Note: Its like a monad but with a twist ??
> 
> Monad return type is another Monad; but user must provided that monad as return type, whereas in Functor return value of applied function is wrapped by Functor in anohter Functor.

**Why Functor can't be chained: - Supose a user choose to return a function after applying an opertion on a value which means functor will double wrap the return function into another Functor which Monads avoid.**


### Monad

Monads are a type of structure used to represent computations that are described as a series of stages. 

In java `Optional` (more) and `Streams` (to lesser extent) are like Monads.

`Optional<U> flatMap(Function<? super T, ? extends Optional<? extends U>> mapper)`

```java
public interface Monad<T> {
    <R> Monad<R> flatMap(Function<T, Monad<R>> mapper);
}

public class Maybe<T> implements Monad<T> {
    private final T value;
    private Maybe(T value) {
        this.value = value;
    }
    public static <T> Maybe<T> just(T value) {
        return new Maybe<>(value);
    }
    public static <T> Maybe<T> nothing() {
        return new Maybe<>(null);
    }
    @Override
    public <R> Maybe<R> flatMap(Function<T, Monad<R>> mapper) {
        if (value == null) {
            return Maybe.nothing();
        } else {
            return (Maybe<R>) mapper.apply(value);
        }
    }
    public T getValue() {
        return value;
    }
    public static void main(String[] args) {
        Maybe<Integer> maybeValue = Maybe.just(10);
        Maybe<Integer> result = maybeValue
            .flatMap(value -> Maybe.just(value * 2))
            .flatMap(value -> Maybe.just(value + 5));
        System.out.println("Result: " + result.getValue()); // Output: Result: 25
        Maybe<Integer> emptyMaybe = Maybe.nothing();
        Maybe<Integer> emptyResult = emptyMaybe
            .flatMap(value -> Maybe.just(value * 2))
            .flatMap(value -> Maybe.just(value + 5));
        System.out.println("Empty Result: " + emptyResult.getValue()); // Output: Empty Result: null
    }
}
```

### Currying

Currying is a functional programming technique where a function that takes multiple arguments is transformed into a sequence of functions, each taking a single argument.

> Abstract Factory is currying

```java
@Test
public void currying() {
    // Define a function that takes two arguments and returns their sum
    Function<Integer, Function<Integer, Integer>> add = x -> y -> x + y;
    // Apply currying to the "add" function
    Function<Integer, Integer> add5 = add.apply(5);
    // Apply the partially applied function
    int result = add5.apply(3);
    System.out.println("Result: " + result); // Output: Result: 8
}
```

### Trampoline

There is no Tail Call Optimization in java for recursive function! Trampoline design for the rescue :-)

```java
public class Trampoline {

    void recCountdown(int n) {
        if (n == 0) {
            System.out.println("DONE!");
            return;
        }
        System.out.println(n);
        recCountdown(n - 1);
    }

    Supplier<?> countdown(int n) {
        if (n == 0) {
            System.out.println("DONE!");
            return null;
        }
        System.out.println(n);
        return () -> countdown(n - 1);
    }

    void trampoline(Supplier<?> s) {
        while (s != null) s = (Supplier<?>) s.get();
    }

    @Test
    public void testTrampoline() {
        new Trampoline().trampoline(new Trampoline().countdown(Integer.MAX_VALUE - 1));
    }

    @Test
    public static void main(String[] args) {
       new Trampoline().recCountdown(Integer.MAX_VALUE - 1); // StackOverflowException as low as 20000
    }
}
```
