import java.util.Objects;
import java.util.Optional;

public class ChainOfResp_2 {
    // Handler functional interface
    @FunctionalInterface
    interface Handler {
        Optional<String> handle(String request);

        // Extension method to connect handlers
        default Handler andThen(Handler next) {
            Objects.requireNonNull(next);
//            return x -> next.handle(handle(x).get()); // This works as well
            return request -> {
                Optional<String> result = this.handle(request);
                return result.isPresent() ? result : next.handle(request);
            };
        }
    }

    public static void main(String[] args) {
        // Handlers
        Handler handleByA = request ->
                request.equalsIgnoreCase("A") ? Optional.of("Handled by A") : Optional.empty();

        Handler handleByB = request ->
                request.equalsIgnoreCase("B") ? Optional.of("Handled by B") : Optional.empty();

        Handler handleByC = request ->
                request.equalsIgnoreCase("C") ? Optional.of("Handled by C") : Optional.empty();

        // Chain of responsibility
        Handler chain = handleByA
                .andThen(handleByB)
                .andThen(handleByC);

        // Test the chain
        String[] testRequests = {"A", "B", "C", "D"};
        for (String test : testRequests) {
            Optional<String> result = chain.handle(test);
            System.out.println("Request: " + test + " => " + result.orElse("Unhandled"));
        }
    }
}