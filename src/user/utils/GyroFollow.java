package user.utils;

import robot.RobotMap;
import robot.runs.RunHandler;
import robot.utils.Condition;

public class GyroFollow {
		public static void followDegrees(double p0, double acceleration, double kp, double ki, int degrees, int target, boolean brake) {
			RobotMap.getMotor("lWheel").resetEncoder();
			RobotMap.getMotor("rWheel").resetEncoder();
			int error = 0;
			int integral = 0;
			
			while(new Condition() {
				@Override
				public boolean evaluate() {
					return (Math.abs(RobotMap.getMotor("lWheel").readEncoder()) < degrees 
							|| Math.abs(RobotMap.getMotor("rWheel").readEncoder()) < degrees);
				}
			}.loopEvaluate()) {	
				error = (int) (RobotMap.getSensor("gyro").read() - target);
				integral += error;
				double correction = General.clampSpeed((error * kp) + (integral * ki));
				if (correction > 0) RobotMap.getChassis().tankDrive(p0 - correction, p0, acceleration);
				else RobotMap.getChassis().tankDrive(p0, p0 + correction, acceleration);
			}
			
			if(brake) RobotMap.getChassis().brake();
			else RobotMap.getChassis().coast();
			
		}
		
		public static void followSeconds(double p0, double acceleration, double kp, double ki, double seconds, int target, boolean brake) {
			int error = 0;
			int integral = 0;
			
			long start = System.currentTimeMillis();
			
			while(RunHandler.isRunning() && System.currentTimeMillis() - start == (long)(seconds * 100)) {	
				System.out.println(System.currentTimeMillis() - start);
				System.out.println((long)(seconds * 100));
				System.out.println(System.currentTimeMillis() - start == (long)(seconds * 100));
				error = (int) (RobotMap.getSensor("gyro").read() - target);
				integral += error;
				double correction = General.clampSpeed((error * kp) + (integral * ki));
				if (correction > 0) RobotMap.getChassis().tankDrive(p0 - correction, p0, acceleration);
				else RobotMap.getChassis().tankDrive(p0, p0 + correction, acceleration);
			}
			
			General.stopRobot(brake);
		}
}
