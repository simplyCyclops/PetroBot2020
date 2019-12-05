package user.utils;

import robot.RobotMap;
import robot.utils.Wait;

public class OldGyroFollow {

	/**
	 * Follows a certain direction in degrees based on the gyro sensor
	 * 	for a certain distance
	 * @param p0 the driving speed
	 * @param distance the distance to drive for in CM
	 * @param direction	the gyro degree the robot should follow
	 * @param kp	the correction intensity, a high value will result in sharper turns 
	 * @param brake	true - brake at the end, false - coast at the end
	 * @param isInverted Whether or not the gyro sensor in upside - down
	 */
	public static void followDegrees(double p0, int distance, int direction, double kp, boolean brake, 
			boolean isInverted) {
		
		//set up error and correction vars
		int error = 0;
		double correction = 0.0;
		
		//reset the wheels' rotation sensor
		RobotMap.getMotor("lWheel").resetEncoder();
		RobotMap.getMotor("rWheel").resetEncoder();
		
		//start drive
		RobotMap.getChassis().tankDrive(p0, p0);
		
		//drive until distance is reached
		while(Math.abs(RobotMap.getMotor("lWheel").readEncoder()) < General.Conversion.cmToDegrees(distance) 
				|| Math.abs(RobotMap.getMotor("lWheel").readEncoder()) < General.Conversion.cmToDegrees(distance)) {
			
			//get the error of the direction
			error = (int) (RobotMap.getSensor("gyro").read() - direction);
			//calculate the correction
			correction = (int) (error * kp);
			
			//check if speed accedes max speed and slow down other wheel instead if it is 
			if(p0 + correction > 1 || p0 + correction < -1) {
				correction = -correction;
				isInverted = !isInverted;
			}
			
			//correct the robot's direction
			if(!isInverted)
				RobotMap.getChassis().tankDrive(p0, General.clampSpeed(p0 + correction));
			else
				RobotMap.getChassis().tankDrive(General.clampSpeed(p0 + correction), p0);
		}
		
		//stop
		if(brake) {
			RobotMap.getChassis().brake();
		} else
			RobotMap.getChassis().coast();

	}
	
	/**
	 * Follows a certain direction in degrees based on the gyro sensor 
	 * 	for a certain amount of time
	 * 
	 * @param p0 the driving speed
	 * @param time how long to drive for in seconds
	 * @param direction	the gyro degree the robot should follow
	 * @param kp	the correction intensity, a high value will result in sharper turns 
	 * @param brake	true - brake at the end, false - coast at the end
	 * @param isInverted Whether or not the gyro sensor in upside - down
	 */
	public static void followSeconds(double p0, double time, int direction, double kp, boolean brake, 
			boolean isInverted) {
		
		//set up error and correction vars
		int error = 0;
		double correction = 0.0;
		
		//the followers correction rate = 1 / delay times per second;
		double delay = 0.25;
		
		//start drive
		RobotMap.getChassis().tankDrive(p0, p0);
		
		//drive until time is up
		for (int i = 0; i < time / delay; i++) {
			
			Wait.waitForSeconds(delay);
			
			//get the error of the direction
			error = (int) (RobotMap.getSensor("gyro").read() - direction);
			//calculate the correction
			correction = (int) (error * kp);
			
			//check if speed accedes max speed and slow down other wheel instead if it is 
			if(p0 + correction > 1 || p0 + correction < -1) {
				correction = -correction;
				isInverted = !isInverted;
			}
			
			//check if speed accedes max speed and slow down other wheel instead if it is 
			if(p0 + correction > 1 || p0 + correction < -1) {
				correction = -correction;
				isInverted = !isInverted;
			}
			
			//correct the robot's direction
			if(!isInverted)
				RobotMap.getChassis().tankDrive(p0, General.clampSpeed(p0 + correction));
			else
				RobotMap.getChassis().tankDrive(General.clampSpeed(p0 + correction), p0);
		}
		
		//stop
		General.stopRobot(brake);

	}

	/**
	 * Follows a certain direction in degrees based on the gyro sensor
	 * 	for a certain distance
	 * @param p0 the driving speed
	 * @param distance the distance to drive in cm
	 * @param direction	the gyro degree the robot should follow
	 * @param kp	the correction intensity, a high value will result in sharper turns 
	 */
	public static void followDegrees(double p0, int distance, int direction, double kp) {
		followDegrees(p0, distance, direction, kp, false, false);
	}
	
	/**
	 * Follows a certain direction in degrees based on the gyro sensor 
	 * 	for a certain amount of time
	 * 
	 * @param p0 the driving speed
	 * @param seconds how long to drive for in seconds
	 * @param direction	the gyro degree the robot should follow
	 * @param kp	the correction intensity, a high value will result in sharper turns 
	 */
	public static void followSeconds(double p0, double seconds, int direction, double kp) {
		followSeconds(p0, seconds, direction, kp, false, false);
	}
	
	/**
	 * Follows a certain direction in degrees based on the gyro sensor
	 * 	for a certain distance
	 * @param p0 the driving speed
	 * @param distance the distance to drive in cm
	 * @param direction	the gyro degree the robot should follow
	 * @param kp	the correction intensity, a high value will result in sharper turns 
	 * @param brake	true - brake at the end, false - coast at the end
	 */
	public static void followDegrees(double p0, int distance, int direction, double kp, boolean brake) {
		followDegrees(p0, distance, direction, kp, brake, false);
	}
	
	/**
	 * Follows a certain direction in degrees based on the gyro sensor 
	 * 	for a certain amount of time
	 * 
	 * @param p0 the driving speed
	 * @param seconds how long to drive for in seconds
	 * @param direction	the gyro degree the robot should follow
	 * @param kp	the correction intensity, a high value will result in sharper turns 
	 * @param brake	true - brake at the end, false - coast at the end
	 */
	public static void followSeconds(double p0, double seconds, int direction, double kp, boolean brake) {
		followSeconds(p0, seconds, direction, kp, brake, false);
	}
}
