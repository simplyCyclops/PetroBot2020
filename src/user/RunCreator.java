package user;

import user.runs.GyroCheckRun;
import user.runs.JohnAccelerate;

public class RunCreator {
	public static void init() {
		new GyroCheckRun("Gyro Check");
		new JohnAccelerate("set acceleration check");
	}
}
