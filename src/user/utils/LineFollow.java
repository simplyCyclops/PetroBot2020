package user.utils;

import robot.RobotMap;

public class LineFollow {
	
	public static void followDegrees(int p0, int distance, int light, double kp, boolean followLeft, boolean brake) {
		
		//reset the wheels' rotation sensor
		RobotMap.getMotor("lWheel").resetEncoder();
		RobotMap.getMotor("rWheel").resetEncoder();
		
		
		String sensor = "lColor";
		if(!followLeft) sensor = "rColor"; //determines the sensor to be followed
		
		int correctionMod; //the modifier for adding / subtracting speed

		
		
		//start drive
		RobotMap.getChassis().tankDrive(p0, p0);
		
		//drive until distance is reached
		while(Math.abs(RobotMap.getMotor("lWheel").readEncoder()) < General.Conversion.cmToDegrees(distance) 
				|| Math.abs(RobotMap.getMotor("lWheel").readEncoder()) < General.Conversion.cmToDegrees(distance)) {

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
	
}
