package dp;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.function.Consumer;

public class Template {

    private void withResource(Consumer<Resource> consumer) {
        Resource resource = new Resource();
        try {
            consumer.accept(resource);
        } finally {
            resource.dispose();
        }
    }

    @Test
    public void test() {
        withResource(resource -> resource.useResource());
        withResource(resource -> resource.employResource());
    }

    private static class Resource {
        public Resource() {
            System.out.println("Resource created");
        }

        public void useResource() {
            riskyOperation();
            System.out.println("Resource used");
        }

        public void employResource() {
            riskyOperation();
            System.out.println("Resource employed");
        }

        public void dispose() {
            System.out.println("Resource disposed");
        }

        private void riskyOperation() {
            if (new Random().nextInt(10) == 0) {
                throw new RuntimeException();
            }
        }

        public static void main(String[] args) {
            Resource resource = new Resource();
            resource.useResource();
            resource.employResource();
            resource.dispose();
        }
    }
}