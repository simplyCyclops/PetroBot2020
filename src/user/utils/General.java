package user.utils;

import robot.RobotMap;

public class General {
	
	public static void stopRobot(boolean brake) {
		if(brake) RobotMap.getChassis().brake();
		else RobotMap.getChassis().coast();
	}
	
	public static double clampSpeed(double speed) {
		if(speed > 1) speed = 1;
		else if(speed < -1) speed = -1;
		
		return speed;
	}
	
	public static class Hardware{
		public static String leftWheel = "lWheel";
		public static String rightWheel = "rWheel";
		
		public static String leftArm = "lArm";
		public static String rightArm = "rArm";
		
		public static String leftColor = "lColor";
		public static String rightColor = "rColor";
		
		public static String gyro = "gyro";
	}
	
	public static class Conversion {

		static double defaultDiameter = 6.24;
		
		public static int cmToDegrees(double cm, double diameter) {
			return (int) ((cm * 360) / (diameter * Math.PI));
		}

		public static int cmToDegrees(double cm) {
			return cmToDegrees(cm, defaultDiameter);
		}
		
		public static double degreesToCm(int degrees, double diameter) {
			return degrees * diameter * Math.PI / 360;
		}
		
		public static double degreesToCm(int degrees) {
			return degreesToCm(degrees, defaultDiameter);
		}
		
		public static void setDefaultDiameter(double diameter) {
			defaultDiameter = diameter;
		}
		
	}
	
}
