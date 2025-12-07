package number;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class NaturalNumberSetNTest {

    /**
     * list: returns the natural number set zValue: depicts the natural number N
     * Arrange a set of n Natural Number like x,y,z such that z > x,y
     */
    public void arrangeNaturalNumberSetN3(List<Integer[]> list, int zValue) {
        for (int z = 1; z <= zValue; z++) {
            for (int x = 1; x < z; x++) {
                for (int y = 1; y < z; y++) {
                    list.add(new Integer[]{x, y, z});
                }
            }
        }
    }

    @Test
    public void testArrangeNaturalNumberSet() {
        ArrayList<Integer[]> list = new ArrayList<>();
        arrangeNaturalNumberSetN3(list, 3);
        for (Integer[] i : list) {
            System.out.println(i[0] + "," + i[1] + "," + i[2]);
        }
    }
}