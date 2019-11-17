package user.utils;

import robot.RobotMap;
import robot.hardware.motors.RobotMotor;
import robot.utils.Wait;

public class Acceleration {

	/**
	 * Accelerates or decelerates both wheels together over a certain period of time
	 * 
	 * @param speeds	The starting and target speeds of the wheels
	 * @param time   The time it should take to get from startSpeed to targetSpeed
	 * @param brake	true - brake at the end, false - coast at the end
	 */
	public static void accelerateSeconds(Accelerator speeds, double time, boolean brake) {
		tankAccelerateSeconds(speeds, speeds, time, brake);
	}

	/**
	 * Accelerates or decelerates both wheels together over a certain period of time
	 * Automatically sets start speeds to current speed of the wheels
	 * 
	 * @param targetLSpeed the target speed for the left wheel
	 * @param targetRSpeed the target speed for the right wheel
	 * @param time   The time it should take to get from startSpeed to targetSpeed
	 * @param brake	true - brake at the end, false - coast at the end
	 */
	public static void accelerateSeconds(double targetLSpeed, double targetRSpeed, double time, boolean brake) {
		tankAccelerateSeconds(new Accelerator(RobotMap.getMotor("lWheel").getCurrentSpeed(),
					targetLSpeed), new Accelerator(RobotMap.getMotor("rWheel").getCurrentSpeed(), targetRSpeed),
				time, brake);
	}
	
	/**
	 * Accelerates or decelerates both wheels together over a certain distance
	 * 
	 * @param speeds	The starting and target speeds of the wheels
	 * @param centimeters   The distance it should take to get from startSpeed to targetSpeed
	 * @param brake	true - brake at the end, false - coast at the end
	 */
	public static void accelerateCentimeters(Accelerator speeds, double centimeters, boolean brake) {
		tankAccelerateSeconds(speeds, speeds, centimeters, brake);
	}

	/**
	 * Accelerates or decelerates both wheels together over a certain distance
	 * Automatically sets start speeds to current speed of the wheels
	 * 
	 * @param targetLSpeed the target speed for the left wheel
	 * @param targetRSpeed the target speed for the right wheel
	 * @param centimeters   The distance it should take to get from startSpeed to targetSpeed
	 * @param brake	true - brake at the end, false - coast at the end
	 */
	public static void accelerateCentimeters(double targetLSpeed, double targetRSpeed, double time, boolean brake) {
		tankAccelerateSeconds(new Accelerator(RobotMap.getMotor("lWheel").getCurrentSpeed(),
					targetLSpeed), new Accelerator(RobotMap.getMotor("rWheel").getCurrentSpeed(), targetRSpeed),
				time, brake);
	}
	
	/**
	 * Accelerates or decelerates both wheels independently over a certain period of time
	 * 
	 * @param leftSpeeds  The starting and target speeds for the left wheel
	 * @param rightSpeeds The starting and target speeds for the right wheel
	 * @param time	The time it should take to get from startSpeed to targetSpeed
	 * @param brake	true - brake at the end, false - coast at the end
	 */
	public static void tankAccelerateSeconds(Accelerator leftSpeeds, Accelerator rightSpeeds,
										double time, boolean brake) {
		
		//sets up current speed vars at start speed
		double currentLSpeed = leftSpeeds.getStartSpeed();
		double currentRSpeed = rightSpeeds.getStartSpeed();

		//calculates how much to add to speed every iteration 
		double incrementL = (leftSpeeds.getTargetSpeed() - leftSpeeds.getStartSpeed()) / time;
		double incrementR = (rightSpeeds.getTargetSpeed() - rightSpeeds.getStartSpeed()) / time;

		double delay = 0.25; //the delay between iterations

		//start drive
		RobotMap.getChassis().tankDrive(currentLSpeed, currentRSpeed);

		//drive until time is up
		for (int i = 0; i < time / delay; i++) {

			Wait.waitForSeconds(delay); //wait for delay

			 //increase speeds
			currentLSpeed += incrementL;
			currentRSpeed += incrementR;

			//clamp L speed
			currentLSpeed = General.clampSpeed(currentLSpeed);

			//clamp R speed
			currentRSpeed = General.clampSpeed(currentRSpeed);
			
			//drive at new speed
			RobotMap.getChassis().tankDrive(currentLSpeed, currentRSpeed);
		}
		
		//stop
		General.stopRobot(brake);
		
	}

	/**
	 *  Accelerates or decelerates both wheels independently over a certain distance
	 *  
	 * @param leftSpeeds  The starting and target speeds for the left wheel
	 * @param rightSpeeds The starting and target speeds for the right wheel
	 * @param centimeters	The distance it should take to get from startSpeed to targetSpeed
	 * @param brake	true - brake at the end, false - coast at the end
	 */
	public static void tankAccelerateCentimeters(Accelerator leftSpeeds, Accelerator rightSpeeds,
										int centimeters, boolean brake) {

		//sets up current speed vars at start speed
		double currentLSpeed = leftSpeeds.getStartSpeed();
		double currentRSpeed = rightSpeeds.getStartSpeed();

		//calculates how much to add to speed every iteration 
		double incrementL = (leftSpeeds.getTargetSpeed() - leftSpeeds.getStartSpeed()) / centimeters;
		double incrementR = (rightSpeeds.getTargetSpeed() - rightSpeeds.getStartSpeed()) / centimeters;

		double delay = 0.25; //the delay between iterations in cm

		//start drive
		RobotMap.getChassis().tankDrive(currentLSpeed, currentRSpeed);

		//drive until distance is reached
		for (int i = 0; i < centimeters / delay; i++) {

			if(centimeters % delay == 0) {

				//increase speeds
				currentLSpeed += incrementL;
				currentRSpeed += incrementR;

				//clamp L speed
				currentLSpeed = General.clampSpeed(currentLSpeed);

				//clamp R speed
				currentRSpeed = General.clampSpeed(currentRSpeed);
				
				//drive at new speed
				RobotMap.getChassis().tankDrive(currentLSpeed, currentRSpeed);
				
			}

		}
		//stop
		General.stopRobot(brake);
	}
	
	/**
	 * An object that stores a start speed and target speed for the acceleration functions
	 *
	 */
	public static class Accelerator {
		
		public Accelerator(double start, double target) {
			this.start = start;
			this.target = target;
		}
		
		private double start;
		private double target;
		
		public double getStartSpeed() {
			return this.start;
		}
		
		public double getTargetSpeed() {
			return this.target;
		}
	}
	
}
