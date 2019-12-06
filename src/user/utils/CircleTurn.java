package user.utils;

import robot.RobotMap;
import robot.utils.Condition;
import user.utils.General.Conversion;

public class CircleTurn {

	static double dis = 5.2;
	
	public static void turn(double maxSpeed, double acceleration, double radius, int degrees, String direction, boolean brake) {
		RobotMap.getMotor("lWheel").resetEncoder();
		RobotMap.getMotor("rWheel").resetEncoder();
		
		double pLeft = 0, pRight = 0;
		double aLeft = 0, aRight = 0;
		final double ratio = ((radius - dis) / (radius + dis));
		
		if(direction.equalsIgnoreCase("right")) {
			pLeft = maxSpeed;
			aLeft = acceleration;
			pRight = maxSpeed * ratio;
			aRight = acceleration * ratio;
		} else {
			pRight = maxSpeed;
			aRight = acceleration;
			pLeft = maxSpeed * ratio;
			aLeft = acceleration * ratio;
		}
		
		int duration = Conversion.cmToDegrees((2 * Math.PI * (radius + dis) * degrees) / 360);
		
		RobotMap.getMotor("lWheel").forward(pLeft, aLeft);
		RobotMap.getMotor("rWheel").forward(pRight, aRight);
		
		while(new Condition() {
			@Override
			public boolean evaluate() {
				return (RobotMap.getMotor("lWheel").readEncoder() < duration && 
						RobotMap.getMotor("rWheel").readEncoder() < duration);
			}
		}.loopEvaluate());
		
		if(brake) RobotMap.getChassis().brake();
		else RobotMap.getChassis().coast();
		
	}
	
}
