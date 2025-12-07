import org.junit.jupiter.api.Test;

public class HanoiTowersTest {

    public void hanoiTowers(int n, char x, char y, char z) {
        if (n == 1) { // basis
            System.out.printf("Move top disk from peg %c to peg %c.%n", x, z);
        } else {
            hanoiTowers(n - 1, x, z, y); // recursion
            hanoiTowers(1, x, y, z); // recursion
            hanoiTowers(n - 1, y, x, z); // recursion
        }
    }

    @Test
    public void testHanoiTowers() {
        hanoiTowers(3, 'A', 'B', 'C');
    }

    /**
     * May be defective
     */
    public void hanoiTowers_1(int n, char start, char temp, char goal) {
        if (n == 0) return;          // Base case
        hanoiTowers_1(n - 1, start, goal, temp); // Recursive call: n-1 rings
        System.out.printf("Move disk from peg %c to peg %c.%n", start, goal); // Move bottom disk to goal
        hanoiTowers_1(n - 1, temp, start, goal); // Recursive call: n-1 rings
    }

    @Test
    public void testHanoiTowers_1() {
        hanoiTowers_1(3, 'A', 'B', 'C');
    }
}
