package user.utils;

import robot.RobotMap;

public class GyroFollow {

	public static void followDegrees(int p0, int distance, int direction, double kp, boolean coast) {
		
		int error = 0;
		double correction;
		
		RobotMap.getMotor("lWheel").resetEncoder();
		RobotMap.getMotor("rWheel").resetEncoder();
		
		RobotMap.getChassis().tankDrive(p0, p0);
		
		while(Math.abs(RobotMap.getMotor("lWheel").readEncoder()) < distance 
				|| Math.abs(RobotMap.getMotor("lWheel").readEncoder()) < distance) {
			
			error = (int) (RobotMap.getSensor("gyro").read() - direction);
			correction = (int) (error * kp + p0);
			
			RobotMap.getChassis().tankDrive(leftSpeed, rightSpeed);
		}
	}
	
}
