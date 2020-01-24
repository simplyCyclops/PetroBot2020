package user.utils;

import lejos.hardware.lcd.LCD;
import robot.RobotMap;
import robot.runs.RunHandler;
import robot.utils.Condition;
import robot.utils.Wait;

public class GyroTurn {

	public static void turnTo(double speed, int target) {
		
		double moveSpeed = speed;
		int direction = 1;
		
		while(RunHandler.isRunning() && RobotMap.getSensor("gyro").read() != target) {
			RobotMap.getChassis().tankDrive(moveSpeed * direction, -moveSpeed * direction);
			if(direction == 1) while(RunHandler.isRunning() && RobotMap.getSensor("gyro").read() < target);
			else while(RunHandler.isRunning() && RobotMap.getSensor("gyro").read() > target);
			RobotMap.getChassis().brake();
			Wait.waitForSeconds(0.3);
			System.out.println(RobotMap.getSensor("gyro").read());
			direction = -direction;
			moveSpeed /= 2;
		}
	}
	
	public static void turnInPlace(double lSpeed, int gyroDegrees, boolean brake) {
		turn(lSpeed, -lSpeed, 1, gyroDegrees, brake);
	}
	
	public static void turn(double lSpeed, double rSpeed, double acceleration, int gyroDegrees, boolean brake) {
		RobotMap.getChassis().tankDrive(lSpeed, rSpeed, acceleration);

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
