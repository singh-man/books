import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class Visitor {

    public static class LambdaVisitor<A> implements Function<Object, A> {
        private Map<Class<?>, Function<Object, A>> fMap = new HashMap<>();

        public <B> Acceptor<A, B> on(Class<B> clazz) {
            return new Acceptor<>(this, clazz);
        }

        @Override
        public A apply(Object o) {
            return fMap.get(o.getClass()).apply(o);
        }

        static class Acceptor<A, B> {
            private final LambdaVisitor visitor;
            private final Class<B> clazz;

            public Acceptor(LambdaVisitor<A> visitor, Class<B> clazz) {
                this.visitor = visitor;
                this.clazz = clazz;
            }

            public LambdaVisitor<A> then(Function<B, A> f) {
                visitor.fMap.put(clazz, f);
                return visitor;
            }
        }
    }

    public static record Square(double side) {
    }

    public static record Circle(double radius) {
    }

    public static record Rectangle(double width, double height) {
    }

    static Function<Object, Double> areaVisitor = new LambdaVisitor<Double>()
            .on(Square.class).then(s -> s.side * s.side)
            .on(Circle.class).then(c -> Math.PI * c.radius * c.radius)
            .on(Rectangle.class).then(r -> r.height * r.width);

    static Function<Object, Double> perimeterVisitor = new LambdaVisitor<Double>()
            .on(Square.class).then(s -> 4 * s.side)
            .on(Circle.class).then(c -> 2 * Math.PI * c.radius)
            .on(Rectangle.class).then(r -> 2 * r.height + 2 * r.width);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var figures = Arrays.asList(new Circle(4), new Square(5), new Rectangle(6, 7));

        double totalArea = figures.stream().map(areaVisitor).reduce(0.0, (v1, v2) -> v1 + v2);
        System.out.println("Total area = " + totalArea);

        double totalPerimeter = figures.stream().map(perimeterVisitor).reduce(0.0, (v1, v2) -> v1 + v2);
        System.out.println("Total perimeter = " + totalPerimeter);

        int LITTLE_ADVICE = 0;
        int MORE_ADVICE = 1;
        int LOTS_OF_ADVICE = 2;
        int howMuchAdvice = MORE_ADVICE;
        int i = switch (howMuchAdvice) {
            case 0 -> LITTLE_ADVICE++;
            case 1 -> ++MORE_ADVICE;
            case 2 -> LITTLE_ADVICE;
            default -> howMuchAdvice;
        };
        System.out.println(i);

        CompletableFuture<String> greetingFuture
                = CompletableFuture.supplyAsync(() -> {
                    // some async computation
                    return "Hello from CompletableFuture";
                })
                .exceptionally(ex -> ex.getMessage());

        System.out.println(greetingFuture.get());

        Optional<String> hello = Optional.of("Hello").flatMap(e -> Optional.of(e + ""));
        Optional<String> hello1 = Optional.of("Hello").map(e -> e + "");
        hello1.or(() -> Optional.of("hi"));
        try (var reader = new BufferedReader(new FileReader(""));) {
            System.out.println("hsdjfsjafjk");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}