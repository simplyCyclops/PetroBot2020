package util;

import robot.utils.RunHandler;

public class Wait {
	
	public static void waitForSeconds(double sec){
		long startWait = System.currentTimeMillis();
		while(System.currentTimeMillis() - startWait < (sec*1000) && RunHandler.getCurrentRun().isActive());
	}
	
}
