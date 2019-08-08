package robot.utils;

/**
 * Static way of accessing currently active run. Used for stopping threads
 * @author John
 */
public class RunHandler {

	private static RobotRun currentRun;
	
	/**
	 * Set the current active run. Do not use unless you know what you are doing!
	 * @param run
	 */
	public static void setCurrentRun(RobotRun run) {
		currentRun = run;
	}
	
	/**
	 * Get the current active run.
	 * @return The RobotRun (thread) object representing the currently active run
	 */
	public static RobotRun getCurrentRun() {
		return currentRun;
	}
	
}
