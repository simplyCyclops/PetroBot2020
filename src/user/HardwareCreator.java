package user;

import robot.hardware.chassis.RobotChassis;
import robot.hardware.sensors.GyroSensor;

public class HardwareCreator {
	public static void init() {
		new RobotChassis("lWheel", 'B', "rWheel", 'C');
		
		new GyroSensor("gyro", 1);
	}
}
