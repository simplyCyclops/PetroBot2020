package user.utils;


import robot.RobotMap;
import robot.runs.RunHandler;

public class LineFollow {
	
	public static double black = 0;
	public static double white = 1;
	static double target = (black + white) / 2;
	
	/**
	 * Follows a line 
	 * @param p0	the driving speed
	 * @param kp	the correction intensity, a high value will result in sharper turns 
	 * @param sensor the name of the sensor to be used
	 * @param side the side of the line to follow
	 */
	public static void follow(double p0, double kp, String sensor, String side) {
		double error = 0;

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
	 * @param kp	the correction intensity, a high value will result in sharper turns 
	 * @param sensor the name of the sensor to be used
	 * @param side the side of the line to follow
	 * @param brake 	true - brake at the end, false - coast at the end
	 */
	public static void followDegrees(double p0, int distance, double kp, String sensor, String side, boolean brake) {
		RobotMap.getMotor("lWheel").resetEncoder();
		RobotMap.getMotor("rWheel").resetEncoder();
		
		double error = 0;

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
	 * @param kp	the correction intensity, a high value will result in sharper turns 
	 * @param sensor the name of the sensor to be used
	 * @param side the side of the line to follow
	 */
	public static void followDegrees(double p0, int distance, double kp, String sensor, String side) {
		followDegrees(p0, distance, kp, sensor, side, true);
	}
	
	/**
	 * Follows a line for a certain distance
	 * @param p0	the driving speed
	 * @param time	how long to drive for in seconds
	 * @param kp	the correction intensity, a high value will result in sharper turns 
	 * @param sensor the name of the sensor to be used
	 * @param side the side of the line to follow
	 * @param brake 	true - brake at the end, false - coast at the end
	 */
	public static void followSeconds(double p0, double time, double kp, String sensor, String side,
			boolean brake) {
			
		double error = 0;
		
		//calculate when to stop driving
		long targetTime = (long) (System.currentTimeMillis() + (time * 1000)); 
		
		//drive until time is up
		while (targetTime > System.currentTimeMillis() && RunHandler.isRunning()) {
			
			if(side.equalsIgnoreCase("left"))
				RobotMap.getChassis().tankDrive(p0 + (error * kp), p0);
			else
				RobotMap.getChassis().tankDrive(p0, p0 + (error * kp));
		}
			
		//stop
		General.stopRobot(brake);
	
	}
	
	/**
	 * Follows a line for a certain distance
	 * @param p0	the driving speed
	 * @param time	how long to drive for in seconds
	 * @param kp	the correction intensity, a high value will result in sharper turns 
	 * @param sensor the name of the sensor to be used
	 * @param side the side of the line to follow
	 */
	public static void followSeconds(double p0, double time, double kp, String sensor, String side) {
		followSeconds(p0, time, kp, sensor, side, true);
	}

	/**
	 * tank drives until sees line
	 * @param leftSpeed the speed for the left wheel
	 * @param rightSpeed the speed for the right wheel
	 * @param sensor the sensor to be used
	 * @param brake true - brake at the end, false - coast at the end
	 */
	public static void untilLine(double leftSpeed, double rightSpeed, String sensor,
			boolean brake) {
		
		//start drive
		RobotMap.getChassis().tankDrive(leftSpeed, rightSpeed);

			while((RobotMap.getSensor(sensor).read() > target + 0.01
					|| RobotMap.getSensor(sensor).read() < target - 0.01)
					&& RunHandler.isRunning()) {}
		//stop
		General.stopRobot(brake);
	}
	
	/**
	 * tank drives until sees line
	 * @param leftSpeed the speed for the left wheel
	 * @param rightSpeed the speed for the right wheel
	 * @param sensor the sensor to be used
	 */
	public static void untilLine(double leftSpeed, double rightSpeed, String sensor) {
		untilLine(leftSpeed, rightSpeed, sensor, true);
	}
	
	/**
	 * straightens on a line
	 * @param p0 the driving speed
	 * @param sensor the sensor to be used
	 * @param brake true - brake at the end, false - coast at the end
	 */
	public static void straighten(double p0, String sensor, boolean brake) {
		
		if(RobotMap.getSensor(sensor).read() > target + 0.01
				|| RobotMap.getSensor(sensor).read() > target + 0.01) {
			untilLine(p0, p0, sensor, false);
		}
		
		String wheel = "lWheel";
		if(sensor.equalsIgnoreCase("rColor")) wheel = "rWheel";
		
		RobotMap.getMotor(wheel).drive(p0);
		
		while((RobotMap.getSensor(sensor).read() > target + 0.01
				|| RobotMap.getSensor(sensor).read() < target - 0.01)
				&& RunHandler.isRunning()) {}
		
		General.stopRobot(brake);
		
	}
	
	/**
	 * straightens on a line
	 * @param p0 the driving speed
	 * @param sensor the sensor to be used
	 */
	public static void straighten(double p0, String sensor) {
		straighten(p0, sensor, true);
	}
	
}
