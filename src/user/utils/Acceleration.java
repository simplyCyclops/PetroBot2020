package user.utils;

import robot.RobotMap;
import robot.utils.Wait;

public class Acceleration {

	/**
	 * Accelerates or decelerates both wheels together over a certain period of time
	 * 
	 * @param speeds	The starting and target speeds of the wheels
	 * @param seconds   The time it should take to get from startSpeed to targetSpeed
	 * @param brake	Whether or not the robot should brake at the end
	 */
	public static void accelerateSeconds(Accelerator speeds, double seconds, boolean brake) {
		tankAccelerateSeconds(speeds, speeds, seconds, brake);
	}

	/**
	 * Accelerates or decelerates both wheels together over a certain distance
	 * 
	 * @param speeds	The starting and target speeds of the wheels
	 * @param centimeters   The distance it should take to get from startSpeed to targetSpeed
	 * @param brake	Whether or not the robot should brake at the end
	 */
	public static void accelerateCentimeters(Accelerator speeds, double centimeters, boolean brake) {
		tankAccelerateSeconds(speeds, speeds, centimeters, brake);
	}
	
	/**
	 * Accelerates or decelerates both wheels independently over a certain period of time
	 * 
	 * @param leftSpeeds  The starting and target speeds for the left wheel
	 * @param rightSpeeds The starting and target speeds for the right wheel
	 * @param seconds	The time it should take to get from startSpeed to targetSpeed
	 * @param brake	Whether or not the robot should brake at the end
	 */
	public static void tankAccelerateSeconds(Accelerator leftSpeeds, Accelerator rightSpeeds,
										double seconds, boolean brake) {

		double currentLSpeed = leftSpeeds.getStartSpeed();
		double currentRSpeed = rightSpeeds.getStartSpeed();

		double incrementL = (leftSpeeds.getTargetSpeed() - leftSpeeds.getStartSpeed()) / seconds;
		double incrementR = (rightSpeeds.getTargetSpeed() - rightSpeeds.getStartSpeed()) / seconds;

		double delay = 0.25;

		RobotMap.getChassis().tankDrive(currentLSpeed, currentRSpeed);

		for (int i = 0; i < seconds / delay; i++) {

			Wait.waitForSeconds(delay);

			currentLSpeed += incrementL;
			currentRSpeed += incrementR;

			RobotMap.getChassis().tankDrive(currentLSpeed, currentRSpeed);
		}
		
		if(brake)
			RobotMap.getChassis().brake();
		else
			RobotMap.getChassis().coast();
		
	}

	/**
	 *  Accelerates or decelerates both wheels independently over a certain distance
	 *  
	 * @param leftSpeeds  The starting and target speeds for the left wheel
	 * @param rightSpeeds The starting and target speeds for the right wheel
	 * @param centimeters	The distance it should take to get from startSpeed to targetSpeed
	 * @param brake	Whether or not the robot should brake at the end
	 */
	public static void tankAccelerateCentimeters(Accelerator leftSpeeds, Accelerator rightSpeeds,
										int centimeters, boolean brake) {

		double currentLSpeed = leftSpeeds.getStartSpeed();
		double currentRSpeed = rightSpeeds.getStartSpeed();

		double incrementL = (leftSpeeds.getTargetSpeed() - leftSpeeds.getStartSpeed()) / centimeters;
		double incrementR = (rightSpeeds.getTargetSpeed() - rightSpeeds.getStartSpeed()) / centimeters;

		double delay = 0.25;

		RobotMap.getChassis().tankDrive(currentLSpeed, currentRSpeed);

		for (int i = 0; i < centimeters / delay; i++) {

			if(centimeters % delay == 0) {

				currentLSpeed += incrementL;
				currentRSpeed += incrementR;

				RobotMap.getChassis().tankDrive(currentLSpeed, currentRSpeed);
				
			}

		}
		if(brake)
			RobotMap.getChassis().brake();
		else
			RobotMap.getChassis().coast();
	}
	
	

}
