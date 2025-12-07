import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class AroundMethod {

    class Resource implements AutoCloseable {
        public Resource op1() {
            System.out.println("opr done 1");
            return this;
        }

        public Resource op2() {
            System.out.println("opr done 2");
            return this;
        }

        @Override
        public void close() throws Exception {
            System.out.println("Resource Closed");
        }
    }

    public void use(Consumer<Resource> block) {
        var resource = new Resource();
        try {
            block.accept(resource);
        } finally {
            try {
                resource.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void test() {
        new AroundMethod().use(resource -> resource
                .op1()
                .op2());
    }
}