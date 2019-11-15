package user.utils;


import robot.RobotMap;
import robot.runs.RunHandler;

public class LineFollow {
	//TODO: update line follower to fit the new follow function
	public static void follow(double p0, double kp, String sensor, String side) {
		double error = 0;
		double target = 0.325;

		while(RunHandler.isRunning()) {
			error =  RobotMap.getSensor(sensor).read() - target;
			
			if(side.equalsIgnoreCase("left"))
				RobotMap.getChassis().tankDrive(p0 + (error * kp), p0);
			else
				RobotMap.getChassis().tankDrive(p0, p0 + (error * kp));
		}
	}
	
	/**
	 * Follows a line for a certain distance
	 * @param p0	the driving speed
	 * @param distance	the distance to drive for in CM
	 * @param light 	the light level for the sensor to follow
	 * @param kp	the correction intensity, a high value will result in sharper turns 
	 * @param followLeft	setting this to false will follow the right light sensor 
	 * @param brake 	true - brake at the end, false - coast at the end
	 */
	public static void followDegrees(double p0, int distance, double kp, String sensor, String side, boolean brake) {
		RobotMap.getMotor("lWheel").resetEncoder();
		RobotMap.getMotor("rWheel").resetEncoder();
		
		double error = 0;
		double target = 0.325;

		while((RobotMap.getMotor("lWheel").readEncoder() < distance 
				|| RobotMap.getMotor("rWheel").readEncoder() < distance) && RunHandler.isRunning()) {
			error =  RobotMap.getSensor(sensor).read() - target;
			
			if(side.equalsIgnoreCase("left"))
				RobotMap.getChassis().tankDrive(p0 + (error * kp), p0);
			else
				RobotMap.getChassis().tankDrive(p0, p0 + (error * kp));
		}
		
		
		General.stopRobot(brake);
	}

	/**
	 * Follows a line for a certain distance
	 * @param p0	the driving speed
	 * @param distance	the distance to drive for in CM
	 * @param light 	the light level for the sensor to follow
	 * @param kp	the correction intensity, a high value will result in sharper turns 
	 * @param followLeft	setting this to false will follow the right light sensor 
	 */
	public static void followDegrees(double p0, int distance, double kp, String sensor, String side) {
		followDegrees(p0, distance, kp, sensor, side, true);
	}
	
	/**
	 * Follows a line for a certain distance
	 * @param p0	the driving speed
	 * @param time	how long to drive for in seconds
	 * @param light 	the light level for the sensor to follow
	 * @param kp	the correction intensity, a high value will result in sharper turns 
	 * @param followLeft	setting this to false will follow the right light sensor 
	 * @param brake 	true - brake at the end, false - coast at the end
	 */
	public static void followSeconds(double p0, double time, double light, double kp, boolean followLeft,
			boolean brake) {
			
		String sensor = "lColor";
		if(!followLeft) sensor = "rColor"; //determines the sensor to be followed
		
		int correctionMod; //the modifier for adding / subtracting speed
		
		//start drive
		RobotMap.getChassis().tankDrive(p0, p0);
		
		//calculate when to stop driving
		long targetTime = (long) (System.currentTimeMillis() + (time * 1000)); 
		
		//drive until time is up
		while (targetTime > System.currentTimeMillis() && RunHandler.isRunning()) {
			
			correctionMod = 1; //sets the correction modifier to add speed
			
			//if sensor is on color - move in opposite direction
			if(RobotMap.getSensor(sensor).read() < light + 0.05
					|| RobotMap.getSensor(sensor).read() > light - 0.05) {
				followLeft = true;
			}
			//if sensor is not on color move toward color
			else {
				followLeft = false;
			}
			
			//check if speed accedes max speed and slow down other wheel instead if it is 
			if(p0 + kp > 1 || p0 + kp < -1) { 
				correctionMod = -1;
				followLeft = !followLeft;
			}
			
			//drive at new corrected speed
			if(followLeft)
				RobotMap.getChassis().tankDrive(p0, p0 + kp * correctionMod);
			else
				RobotMap.getChassis().tankDrive(p0 + kp * correctionMod, p0);
		}
			
		//stop
		General.stopRobot(brake);
	
	}
	
	/**
	 * Follows a line for a certain distance
	 * @param p0	the driving speed
	 * @param time	how long to drive for in seconds
	 * @param light 	the light level for the sensor to follow
	 * @param kp	the correction intensity, a high value will result in sharper turns 
	 * @param followLeft	setting this to false will follow the right light sensor 
	 */
	public static void followSeconds(double p0, double time, double light, double kp, boolean followLeft) {
		followSeconds(p0, time, light, kp, followLeft, true);
	}

	public static void untilColor(double leftSpeed, double rightSpeed, double light, boolean followLeft,
			boolean brake) {
		
		//determine the sensor to be followed
		String sensor = "lColor";
		if(!followLeft) sensor = "rightColor";
		
		//start drive
		RobotMap.getChassis().tankDrive(leftSpeed, rightSpeed);
		
		//wait until chosen sensor sees light
		while((RobotMap.getSensor("lColor").read() > light + 0.05
				|| RobotMap.getSensor("lColor").read() < light - 0.05)
				&& RunHandler.isRunning()) {}
		
		//stop
		General.stopRobot(brake);
	}
	
}
