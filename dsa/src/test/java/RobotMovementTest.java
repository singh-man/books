import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Robot on an infinite grid can move N - S - W - E
 * Find below!!
 */
public class RobotMovementTest {

    /**
     * Find if Robot ends at same location where it started!!
     * or Find if robot completes a loop
     * Idea: initial position 0,0 x -> horizontal axis y-> vertical axis
     * Commands: like N, N, W, S, E
     */
    private boolean robotComesToStartOrLoop(String[] commands) {
        int x = 0, y = 0;
        for (String c : commands) {
            if(c.equals("N")) y++;
            else if (c.equals("S")) y--;
            else if (c.equals("E")) x++;
            else if (c.equals("W")) x--;
        }
        return x == 0 && y == 0;
    }

    @Test
    public void testFindLoop() {
        String[] command = {"N", "N", "W", "S", "E", "N"};
        Assertions.assertFalse(robotComesToStartOrLoop(command));
        command = new String[]{"N", "N", "W", "S", "E", "S"};
        Assertions.assertTrue(robotComesToStartOrLoop(command));
    }


    private boolean robotCrossesPath(String[] commands) {
        class XY {
            int x, y;

            public XY(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                XY xy = (XY) o;
                return x == xy.x && y == xy.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }
        int x = 0, y = 0;
        Set<XY> xy = new HashSet<>();
        for (String c : commands) {
            if(c.equals("N")) y++;
            else if (c.equals("S")) y--;
            else if (c.equals("E")) x++;
            else if (c.equals("W")) x--;
            if(xy.contains(new XY(x, y))) return true;
            xy.add(new XY(x, y));
        }
        return false;
    }

    @Test
    public void testFindPathCrosses() {
        String[] command = {"N", "N", "W", "S", "E", "N"};
        Assertions.assertTrue(robotCrossesPath(command));
        command = new String[]{"N", "N", "W", "S"};
        Assertions.assertFalse(robotComesToStartOrLoop(command));
    }

}
