package user.utils;

import robot.RobotMap;
import robot.runs.RunHandler;
import robot.utils.Wait;

public class GyroTurn {

	public static void turnTo(double lSpeed, double rSpeed, int target) {	
		Wait.waitForSeconds(0.3);
		double moveSpeed = 1;
		int direction = 1;
		
		if(RobotMap.getSensor("gyro").read() > target) direction = -1;
		
		while(RunHandler.isRunning() && RobotMap.getSensor("gyro").read() != target) {
			
			RobotMap.getChassis().tankDrive(lSpeed * moveSpeed * direction, rSpeed * moveSpeed * direction);
			
			if(direction == 1) 
				while(RunHandler.isRunning() && RobotMap.getSensor("gyro").read() < target);
			else 
				while(RunHandler.isRunning() && RobotMap.getSensor("gyro").read() > target);
			
			RobotMap.getChassis().brake();
			Wait.waitForSeconds(0.3);
			
			//System.out.println(RobotMap.getSensor("gyro").read());
			
			direction = -direction;
			moveSpeed /= 2;
		}
		Wait.waitForSeconds(0.1);
	}
	
	public static void turnTo(double speed, int target) {
		turnTo(speed, -speed, target);
	}
	
	/**
	 * Turns the robot a certain amount of degrees. 
	 * Direction in based on angle
	 * @param lSpeed The speed of the left wheel
	 * @param rSpeed The speed of the left wheel
	 * @param acceleration
	 * @param angle The amount of degrees to turn
	 * @param brake Whether the robot should brake or coast at the end
	 */
	public static void tankTurn(double lSpeed, double rSpeed, int angle) {
		turnTo(lSpeed, rSpeed, (int)RobotMap.getSensor("gyro").read() + angle);
	}
	
	public static void turn(double speed, int angle) {
		tankTurn(speed, -speed, angle);
	}
	
	/*public static void turnInPlace(double lSpeed, int gyroDegrees, boolean brake) {
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
	}*/

}
