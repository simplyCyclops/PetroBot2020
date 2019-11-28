package user.utils;

import robot.RobotMap;
import robot.utils.Condition;
import robot.utils.wait.Wait;

public class GyroTurn {

	public static void turnInPlace(double lSpeed, int gyroDegrees, boolean brake) {
		turn(lSpeed, -lSpeed, gyroDegrees, brake);
	}
	
	public static void turn(double lSpeed, double rSpeed, int gyroDegrees, boolean brake) {
		RobotMap.getChassis().tankDrive(lSpeed, rSpeed);

		if (RobotMap.getSensor("gyro").read() > gyroDegrees) {
			Wait.waitFor(new Condition() {
				@Override
				public boolean evaluate() {
					return RobotMap.getSensor("gyro").read() < gyroDegrees;
				}
			});
		} else if (RobotMap.getSensor("gyro").read() < gyroDegrees) {
			Wait.waitFor(new Condition() {
				@Override
				public boolean evaluate() {
					return RobotMap.getSensor("gyro").read() > gyroDegrees;
				}
			});
		}

		if (brake)
			RobotMap.getChassis().brake();
		else
			RobotMap.getChassis().coast();
	}

}
