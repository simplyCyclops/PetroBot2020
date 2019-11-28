package user.utils;

import robot.RobotMap;
import robot.utils.Condition;

public class NewGyroFollow {
		public static void followDegrees(double p0, double acceleration, double kp, int degrees, int target, boolean brake) {
			RobotMap.getMotor("lWheel").resetEncoder();
			RobotMap.getMotor("rWheel").resetEncoder();
			int error = 0;
			
			while(new Condition() {
				@Override
				public boolean evaluate() {
					return (RobotMap.getMotor("lWheel").readEncoder() < degrees 
							&& RobotMap.getMotor("rWheel").readEncoder() < degrees);
				}
			}.loopEvaluate()) {	
				error = (int) (RobotMap.getSensor("gyro").read() - target);
				double correction = General.clampSpeed((error * kp));
				if (correction > 0) RobotMap.getChassis().tankDrive(p0 - correction, p0, acceleration);
				else RobotMap.getChassis().tankDrive(p0, p0 + correction, acceleration);
			}
			
			if(brake) RobotMap.getChassis().brake();
			else RobotMap.getChassis().coast();
			
		}
}
