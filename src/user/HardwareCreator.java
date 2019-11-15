package user;

import robot.hardware.chassis.RobotChassis;
import robot.hardware.motors.LargeMotor;
import robot.hardware.sensors.ColorSensor;
import robot.hardware.sensors.GyroSensor;

public class HardwareCreator {
	public static void init() {
		new RobotChassis("lWheel", 'B', "rWheel", 'C');
		
		new LargeMotor("lArm", 'A');
		new LargeMotor("rArm", 'D');
		
		new GyroSensor("gyro", 1);
		
		new ColorSensor("lColor", 2);
		new ColorSensor("rColor", 3);

	}
}
