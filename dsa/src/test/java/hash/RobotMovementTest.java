package hash;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        record XY(int x, int y) { }
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
        Assertions.assertTrue(robotCrossesPath(command), "Robot should have crossed the path");
        command = new String[]{"N", "N", "W", "S"};
        Assertions.assertFalse(robotCrossesPath(command), "Robot shouldn't have crossed the path");
    }

}
