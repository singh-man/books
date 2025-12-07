import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ChainOfResp_3_no_use {

    @FunctionalInterface
    interface LogHandler {
        void handle(Level level, String message);

        default LogHandler andThen(LogHandler nextHandler) {
            return (level, message) -> {
                this.handle(level, message);
                nextHandler.handle(level, message);
            };
        }
    }

    private LogHandler logChain;

    @Test
    public void test() {
        // Chain of Responsibility setup using lambdas
        LogHandler infoHandler = (level, message) -> {
            if (level == Level.INFO) {
                System.out.println("INFO: " + message);
            }
        };

        LogHandler debugHandler = (level, message) -> {
            if (level == Level.FINE) {
                System.out.println("FINE/DEBUG: " + message);
            }
        };

        LogHandler errorHandler = (level, message) -> {
            if (level == Level.SEVERE) {
                System.out.println("SEVERE/ERROR: " + message);
            }
        };

        // Create the chain
        logChain = infoHandler
                .andThen(debugHandler)
                .andThen(errorHandler);

        Logger logger = Logger.getLogger(this.getClass().getName());
        // Let's test different scenarios:
        logChain.handle(Level.INFO, "This is an informational message.");
        logChain.handle(Level.FINE, "This is a fine/ebug message, something minor.");
        logChain.handle(Level.SEVERE, "This is an severe/error message, something failed.");
    }
}

