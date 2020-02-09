package user;

import robot.hardware.chassis.RobotChassis;
import robot.hardware.motors.LargeMotor;
import robot.hardware.sensors.ColorSensor;
import robot.hardware.sensors.GyroSensor;
import user.runs.ColorReset;
import user.runs.GyroCheckRun;
import user.runs.Run1;
import user.runs.Run4;
import user.runs.Run2;
import user.runs.Run3;
import user.runs.TestRun;
import user.utils.GyroFollow;

public class Startup {

	public static void createHardware() {
		new RobotChassis("lWheel", 'B', "rWheel", 'C');

		new LargeMotor("lArm", 'A');
		new LargeMotor("rArm", 'D');

		new GyroSensor("gyro", 1);

		new ColorSensor("lColor", 2);
		new ColorSensor("rColor", 3);
	}

	public static void createRuns() {
		new ColorReset("Color Reset");
		new Run1("Run 1");
		new Run2("Run 2");
		new Run3("Run 3");
		new Run4("Run 4");

		new GyroCheckRun("[Gyro Test]");
		
		// this run is for testing idea on the fly | do not delete | keep at the bottom
		new TestRun("[Test Run]");
	}

	public static void init() {
		// code that you want to run ONCE
		// before the main menu starts
		GyroFollow.followDegrees(0.1, 0.9, 0.012, 0.012, 200, 0, true);
	}

}
