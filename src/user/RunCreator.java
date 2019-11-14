package user;

import user.runs.GyroCheckRun;
import user.runs.TestRun;

public class RunCreator {
	public static void init() {
		new GyroCheckRun("Gyro Check");
		
		//this run is for testing idea on the fly | do not delete | keep at the bottom
		new TestRun("[Test Run]"); 
	}
}
