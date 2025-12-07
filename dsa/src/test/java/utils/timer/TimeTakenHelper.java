package utils.timer;

public class TimeTakenHelper {

	public static void calculateTime(String s, TimeTaken... timeTaken) {
		long t1 = 0;

		for(TimeTaken tTaken : timeTaken) {
			t1 = System.currentTimeMillis();
			
			tTaken.calculateTimeTaken();
			
			System.out.println(s + " : " + (System.currentTimeMillis() - t1));
		}
	}
}