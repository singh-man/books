package utils;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

public class HashSetVsTreeSet {

    private String generateRandomStrings() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 70;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    @Test
    public void testGenerateRandomStrings() {
        String generatedString = generateRandomStrings();
        System.out.println(generatedString);
    }

    private record HashSetAndTreeSet(HashSet<String> hashSet, TreeSet<String> treeSet) {}

    private void prepareSetData(Set<String> s) {
        IntStream.range(0, 500).forEach(i -> s.add(i + "." + generateRandomStrings()));
        s.add("This is the text to be searched and find for me.");
    }

    private HashSetAndTreeSet initSets() {
        HashSetAndTreeSet hashSetAndTreeSet = new HashSetAndTreeSet(new HashSet<>(), new TreeSet<>());
        prepareSetData(hashSetAndTreeSet.hashSet);
        prepareSetData(hashSetAndTreeSet.treeSet);
        return hashSetAndTreeSet;
    }

    private void checkSetPerformance(Set<String> s) {
        long t1 = System.nanoTime();
        s.contains("This is the text to be searched and find for me.");
        System.err.println(String.format("For type %s, time taken %s", s.getClass(), (System.nanoTime() - t1)));
    }

    public static void main(String[] args) {
        HashSetVsTreeSet o = new HashSetVsTreeSet();
        HashSetAndTreeSet hashSetAndTreeSet = o.initSets();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter e only if u wanna exit.");
        String s = scan.next();
        while (!s.equals("e")) {
            o.checkSetPerformance(hashSetAndTreeSet.hashSet);
            o.checkSetPerformance(hashSetAndTreeSet.treeSet);
            System.out.println("Enter e only if u wanna exit.");
            s = scan.next();
        }
    }
}