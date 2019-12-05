package robot.utils;

import lejos.utility.Delay;
import robot.runs.RunHandler;

public class Wait {

	private Wait() {}
	
	public static void waitFor(Condition condition) {
		while(!condition.evaluate() && RunHandler.isRunning()) {
			Delay.msDelay(1); //Does not work if not present
			//TODO: investigate
		}
	}
	
	public static void waitForSeconds(double seconds) {
		if (seconds < 0) throw new IllegalArgumentException("Seconds must be positive!");
		long startTime = System.currentTimeMillis();
		while (System.currentTimeMillis() - startTime < seconds * 1000
				&& RunHandler.isRunning()) {
			Delay.msDelay(1); //Does not work if not present
			//TODO: investigate
		};
	}
	
}
