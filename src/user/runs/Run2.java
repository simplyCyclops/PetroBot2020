package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Action;
import robot.utils.Condition;
import robot.utils.Wait;
import user.utils.CircleTurn;
import user.utils.General.Conversion;
import user.utils.GyroFollow;

public class Run2 extends RobotRun {

	public Run2(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		
		RobotMap.getSensor("gyro").resetToCurrentValue();
		
		/*RobotMap.getChassis().tankDriveDegrees(0.8, 0.8, 0.2, Conversion.cmToDegrees(50), true);
		GyroTurn.turnInPlace(0.1, 47, true);
		GyroFollow.followDegrees(0.8, 1.0, 0.012, 0.0, Conversion.cmToDegrees(128), 47, false);
		RobotMap.getMotor("lWheel").setAcceleration(0.2);
		RobotMap.getMotor("rWheel").setAcceleration(0.2);
		RobotMap.getChassis().brake();*/
		
		RobotMap.getChassis().forwardDriveDegrees(0.2, 0.6, Conversion.cmToDegrees(9.5), true);
		new Action() {
			
			@Override
			public void execute() {
				RobotMap.getMotor("lArm").rotateDegrees(-0.8, 1080, true);
			}
		}.runInParallel();
		
		Wait.waitForSeconds(0.3);
		CircleTurn.turn(0.4, 0.6, 28, 101, "right", false);
		GyroFollow.followDegrees(0.4, 0.7, 0.01, 0, Conversion.cmToDegrees(120), 90, false);
		RobotMap.getChassis().tankDriveDegrees(0.2, 0.2, 0.5, Conversion.cmToDegrees(9.35), true);
		Wait.waitForSeconds(0.5);
		
		RobotMap.getMotor("lArm").rotateDegrees(0.6, 0.5, 630, true);
		RobotMap.getChassis().backwardDriveDegrees(0.2, 0.4, Conversion.cmToDegrees(3.5), true);
		RobotMap.getMotor("lArm").rotateDegrees(0.6, 0.5, 530, true);
		
		/*RobotMap.getChassis().backwardDriveDegrees(0.3, 0.4, 350, true);
		GyroTurn.turnInPlace(0.1, 67, true);
		RobotMap.getChassis().forwardDriveDegrees(0.6, 0.4, 520, true);*/
		
		/*GyroFollow.followDegrees(-0.7, 0.3, 0.012, 0, Conversion.cmToDegrees(20), 90, false);
		
		new Action() {
			
			@Override
			public void execute() {
				RobotMap.getMotor("lArm").rotateDegrees(-0.8, 1160, true);
			}
		}.runInParallel();
		
		RobotMap.getChassis().tankDriveDegrees(0.3, -0.3, 0.3, 75, true);
		RobotMap.getChassis().forwardDriveDegrees(0.5, 0.3, Conversion.cmToDegrees(30), true);*/
		
		RobotMap.getChassis().tankDriveDegrees(0.4, -0.4, 0.1, 98, true);
		RobotMap.getChassis().forwardDriveDegrees(0.4, 0.6, Conversion.cmToDegrees(18), true);
		RobotMap.getChassis().tankDriveDegrees(-0.4, 0.4, 0.1, 90, true);
		
		RobotMap.getChassis().tankDrive(-0.6, -0.5, 0.6);

		new Condition() {
			
			@Override
			public boolean evaluate() {
				return RobotMap.getSensor("gyro").read() == 90;
			}
		}.loopEvaluate();
		
		RobotMap.getChassis().tankDrive(-0.8, -0.8, 0.8);
	}

}
