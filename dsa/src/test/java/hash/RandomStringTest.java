package hash;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class RandomStringTest {

    @Test
    public void testGenerateRandomStrings() {
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
        String generatedString = buffer.toString();
        System.out.println(generatedString);
    }

    /**
     * To get the count of each type of character in a String
     */
    public void charMapInAString(Map map, String testString) {
        for (int i = 0; i < testString.length(); i++) {
            char key = testString.charAt(i);
            if (map.containsKey(key)) {
                map.put(key, Integer.parseInt(map.get(key).toString()) + 1);
            } else {
                map.put(key, 1);
            }
        }
    }

    /**
     * Sample output for the given Test String
     * $:2,1:3,4:1,5:1,^:3,a:3,b:2,c:2,r:1,t:2
     */
    @Test
    public void testCharMapInAString() {
        System.out.println("\nCharacter mapping/count in a String");
        Map<String, Integer> charMapInString = new TreeMap<>();
        charMapInAString(charMapInString, "abtc^^abc11451$rt$a^");
        System.out.println("char : count ==> no of char? " + charMapInString.size());
        Iterator it = charMapInString.keySet().iterator();
        while (it.hasNext()) {
            Object key = it.next();
            System.out.println(key + "    : " + charMapInString.get(key));
        }
    }
}