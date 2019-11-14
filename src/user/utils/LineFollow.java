package user.utils;

import robot.RobotMap;

public class LineFollow {
	
	public static void followDegrees(int p0, int distance, int light, double kp, boolean brake) {
		
		//reset the wheels' rotation sensor
		RobotMap.getMotor("lWheel").resetEncoder();
		RobotMap.getMotor("rWheel").resetEncoder();
		
		//start drive
		RobotMap.getChassis().tankDrive(p0, p0);
		
		//drive until distance is reached
		while(Math.abs(RobotMap.getMotor("lWheel").readEncoder()) < General.Conversion.cmToDegrees(distance) 
				|| Math.abs(RobotMap.getMotor("lWheel").readEncoder()) < General.Conversion.cmToDegrees(distance)) {
			
			double lCorrection = 0;
			double rCorrection = 0;
			
			//correct left wheel if is off color
			if(RobotMap.getSensor("lColor").read() > light + 0.05
					|| RobotMap.getSensor("lColor").read() < light - 0.05) {
				lCorrection = kp;
			}
			//correct right wheel if is off color
			if(RobotMap.getSensor("rColor").read() > light + 0.05
					|| RobotMap.getSensor("rColor").read() < light - 0.05) {
				rCorrection = kp;
			}
			
			//stop robot if both sensors don't detect a line
			if(lCorrection == kp && rCorrection == kp) {
				General.stopRobot(brake);
				return;
			}
			
			//drive at the new corrected speed
			RobotMap.getChassis().tankDrive(p0 + lCorrection, p0 + rCorrection);
			
		}
		//stop
		General.stopRobot(brake);

	}
	
}
