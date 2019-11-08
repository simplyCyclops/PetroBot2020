package user.utils;

public class Conversion {

	public static int cmToDegrees(double cm, double diameter) {
		return (int) ((cm * 360) / (diameter * Math.PI));
	}
	
	public static double degreesToCm(int degrees, double diameter) {
		return degrees * diameter * Math.PI / 360;
	}
	
}
