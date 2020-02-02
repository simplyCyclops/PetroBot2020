package user.runs;

import lejos.hardware.Button;
import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Action;
import robot.utils.Wait;
import user.utils.CircleTurn;
import user.utils.General.Conversion;
import user.utils.GyroFollow;
import user.utils.GyroTurn;
import user.utils.LineFollow;

public class Run2 extends RobotRun {

	public Run2(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		
		RobotMap.getSensor("gyro").resetToCurrentValue();
		
		RobotMap.getChassis().forwardDriveDegrees(0.2, 0.6, Conversion.cmToDegrees(9), false);
		new Action() {
			
			@Override
			public void execute() {
				RobotMap.getMotor("lArm").rotateDegrees(-0.8, 1000, true);
			}
		}.runInParallel();
		
		Wait.waitForSeconds(0.3);
		CircleTurn.turn(0.4, 0.6, 26, 92, "right", false);
				
		LineFollow.followDegrees(0.3, Conversion.cmToDegrees(20), 0.15, "rColor", "left");
		GyroTurn.turnTo(0.1, 90);
		System.out.println(RobotMap.getSensor("gyro").read());
		
		GyroFollow.followDegrees(0.4, 0.3, 0.02, 0, Conversion.cmToDegrees(85), 90, true);	//false?
		GyroTurn.turnTo(0.1, 90);

		Button.waitForAnyPress();
		
		GyroFollow.followDegrees(0.2, 0.3, 0.02, 0, Conversion.cmToDegrees(32.2), 90, true);	//false?

		//RobotMap.getChassis().tankDriveDegrees(0.2, 0.2, 0.5, Conversion.cmToDegrees(27.2), true);
		Wait.waitForSeconds(0.5);
		
		
		RobotMap.getMotor("lArm").rotateDegrees(0.6, 0.5, 650, true);
		RobotMap.getChassis().backwardDriveDegrees(0.2, 0.4, Conversion.cmToDegrees(3.5), true);
		RobotMap.getMotor("lArm").rotateDegrees(0.6, 0.5, 450, true);
		
		RobotMap.getChassis().tankDriveDegrees(0.4, -0.4, 0.1, 107, true);
		RobotMap.getChassis().forwardDriveDegrees(0.4, 0.6, Conversion.cmToDegrees(15), true);
		RobotMap.getMotor("lArm").rotateDegrees(-0.8, 500, true);
		Wait.waitForSeconds(0.3);
		RobotMap.getMotor("lArm").rotateDegrees(0.8, 500, true);
		
		RobotMap.getChassis().tankDriveDegrees(-0.4, 0.4, 0.6, 98, false);

		RobotMap.getChassis().tankDriveDegrees(-0.8, -0.8, 0.6, Conversion.cmToDegrees(155), false);
		RobotMap.getChassis().tankDriveDegrees(-0.8, -0.85, 0.6, Conversion.cmToDegrees(100), false);

	}

}
