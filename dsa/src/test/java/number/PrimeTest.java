package number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.timer.StopWatch;
import utils.timer.TimeTaken;
import utils.timer.TimeTakenHelper;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrimeTest {
    /**
     * Checks whether the passed number is prime
     * <p>
     * Logic: based on limiting value for e.g. take 101 1. Start dividing the
     * number from 2 till the number 2. 101/2 = 50 --> check this 2, 50 are the
     * multiples of the number that means 3. next divisor range will be b/w 3
     * and 50 4. 101/3 = 33 --> signifies next divisor will be b/w 4 and 33
     * <p>
     * narrowing is done in this way
     * <p>
     * Note: The logic depicts that the highest multiple a number can have, is
     * its sqrt(number) or the highest number which can divide a given number is
     * its sqrt(number)
     * <p>
     * So the number of iteration will be = Math.ceil(Math.sqrt(number)) if used
     * this mathematical formula; limitingValue check and calculation(is done to
     * make it more generic) is not required
     */
    public boolean isPrimeNumber(long number) {
        long limitingValue = number; // limitingValue plays a very significant role here
        for (long i = 2; i <= limitingValue; i++) {
            if (number % i == 0) {
                return false;
            } else if (i == (limitingValue - 1) || i == limitingValue || i == limitingValue + 1) {
                return true;
            }
            limitingValue = number / i;
            if (i == limitingValue) {
                return true;
            }
        }
        return false;
    }

    /**
     * Limited by max Integer value and also if i * j reaches max integer
     * @param n
     */
    @Deprecated
    public List<Integer> calculatePrimeNumbers_v1(int n) {
        boolean[] isPrimeNumber = new boolean[n + 1]; // boolean defaults to false
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            isPrimeNumber[i] = true;
        }
        for (int i = 2; i < n; i++) {
            if (isPrimeNumber[i]) {
                primes.add(i);
                // Now mark the multiple of i as non-prime number
                for (int j = i; j * i <= n; j++) {
                    isPrimeNumber[i * j] = false;
                }
            }

        }
        return primes;
    }

    @Test
    public void testIsPrime() {
        StopWatch sw = new StopWatch().start();

        Assertions.assertTrue(isPrimeNumber(32416190071l));
        sw.log("Time : ");
        Assertions.assertTrue(isPrimeNumber(9999973));
        sw.log("Time : ");
        Assertions.assertFalse(isPrimeNumber(999963));
        sw.log("Time : ");
        Assertions.assertTrue(isPrimeNumber(15486101));
        sw.log("Time : ");
        sw.printConsole();
    }

    @Test
    /**
     * Integer.MAX_VALUE = 2147483647
     */
    public void testListPrimeNumbersInRangeToAFile() throws IOException {
        int noOfPrimes = 0;
        long start = 1;
        long end = 1000000L;
        long t1 = System.currentTimeMillis();
        File file = new File("primeNumberList.txt");
        file.createNewFile();
        PrintWriter pw = new PrintWriter(file);
        while (start <= end) {
            if (isPrimeNumber(start)) {
                noOfPrimes++;
                pw.println(noOfPrimes + ". " + start);
            }
            start++;
        }
//        pw.println("Total primes: " + noOfPrimes + " time taken: " + (System.currentTimeMillis() - t1));
//        pw.flush();
//        System.out.println("Check output in file: " + file.getAbsolutePath());
//        BufferedReader br = new BufferedReader(new FileReader(file));
//        System.out.println("Enter text here: " + br.readLine());
    }

    @Test
    /**
     * Integer.MAX_VALUE = 2147483647
     */
    public void testListPrimeNumbersInRange() throws IOException {
        final List<Integer> primesList = new LinkedList<>();
        int i = 1;
        int end = Integer.MAX_VALUE / 10000;
        while (i <= end) {
            if (isPrimeNumber(i)) {
                primesList.add(i);
            }
            i++;
        }
        System.out.println("No. of primes found = " + primesList.size());
    }

    @Test
    public void testCalculatePrimeNumbers_v1() throws IOException {
        TimeTakenHelper.calculateTime("Time Taken", new TimeTaken() {
            @Override
            public void calculateTimeTaken() {
                List<Integer> primesList = calculatePrimeNumbers_v1(21);
                System.out.println("No. of primes found = " + primesList.size());
            }
        });

    }
}