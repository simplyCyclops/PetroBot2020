package user.utils;

import robot.RobotMap;

public class General {
	
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
	
	public static void stopRobot(boolean brake) {
		if(brake) RobotMap.getChassis().brake();
		else RobotMap.getChassis().coast();
	}
	
}
