package user;

import user.runs.GyroCheckRun;

public class RunCreator {
	public static void init() {
		new GyroCheckRun("Gyro Check");
	}
}
