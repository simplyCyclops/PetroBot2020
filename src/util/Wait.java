package util;

import robot.utils.RunHandler;

/**
 * Run-compatible wait commands. Use these instead of Thread.sleep and Delay.msdelay, etc.
 * Add your own wait commands here.
 * @author John
 *
 */
public class Wait {
	
	/**
	 * Wait for n seconds
	 * @param sec Seconds to wait
	 */
	public static void waitForSeconds(double sec){
		long startWait = System.currentTimeMillis();
		while(System.currentTimeMillis() - startWait < (sec*1000) && RunHandler.getCurrentRun().isActive());
	}
	
}
