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

> Note: Its like a monad but with a twist 
> Monad return type is another Monad but user has provided that monad whereas in functor return value of applied function is wrpped by Functor in anohter Functor.

**Why Functor can't be chained: - Supose a user choose to return a function after applying an opertion on a value which means functor will double wrap the return function into another Functor which Monads avoid.**


### Monad

Monads are a type of structure used to represent computations that are described as a series of stages. 

In java Optional and Streams

'Optional<U> flatMap(Function<? super T, ? extends Optional<? extends U>> mapper)'

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
