package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Action;
import robot.utils.Condition;
import robot.utils.Wait;
import user.utils.CircleTurn;
import user.utils.General.Conversion;
import user.utils.GyroFollow;
import user.utils.GyroTurn;

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
		
		RobotMap.getChassis().forwardDriveDegrees(0.2, 0.6, Conversion.cmToDegrees(11.9), false);
		new Action() {
			
			@Override
			public void execute() {
				RobotMap.getMotor("lArm").rotateDegrees(-0.8, 1100, true);
			}
		}.runInParallel();
		
		Wait.waitForSeconds(0.3);
		CircleTurn.turn(0.4, 0.6, 26, 99, "right", true);
		
		GyroTurn.turnTo(0.1, 90);
		
		GyroFollow.followDegrees(0.4, 0.1, 0.02, 0, Conversion.cmToDegrees(120), 90, true);
		GyroTurn.turnTo(0.1, 90);

		RobotMap.getChassis().tankDriveDegrees(0.2, 0.2, 0.5, Conversion.cmToDegrees(11.2), true);
		Wait.waitForSeconds(0.5);
		
		
		RobotMap.getMotor("lArm").rotateDegrees(0.6, 0.5, 690, true);
		RobotMap.getChassis().backwardDriveDegrees(0.2, 0.4, Conversion.cmToDegrees(3.5), true);
		RobotMap.getMotor("lArm").rotateDegrees(0.6, 0.5, 470, true);
		
		RobotMap.getChassis().tankDriveDegrees(0.4, -0.4, 0.1, 107, true);
		RobotMap.getChassis().forwardDriveDegrees(0.4, 0.6, Conversion.cmToDegrees(15), true);
		RobotMap.getMotor("lArm").rotateDegrees(-0.8, 700, true);
		Wait.waitForSeconds(0.3);
		RobotMap.getMotor("lArm").rotateDegrees(0.8, 700, true);
		
		RobotMap.getChassis().tankDriveDegrees(-0.4, 0.4, 0.6, 100, false);

		RobotMap.getChassis().tankDriveDegrees(-0.8, -0.8, 0.6, Conversion.cmToDegrees(230), false);
	}

}
