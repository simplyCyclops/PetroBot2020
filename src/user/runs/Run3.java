package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Wait;
import user.utils.CircleTurn;
import user.utils.General.Conversion;
import user.utils.GyroFollow;

public class Run3 extends RobotRun {

	public Run3(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		RobotMap.getSensor("gyro").resetToCurrentValue();
		
		RobotMap.getChassis().forwardDriveDegrees(0.2, 0.6, Conversion.cmToDegrees(7), true);
		Wait.waitForSeconds(0.3);
		CircleTurn.turn(0.6, 0.3, 30, 105, "right", true);

		GyroFollow.followDegrees(0.6, 0.3, 0.012, 0, Conversion.cmToDegrees(45.5), 90, false);
		RobotMap.getMotor("rArm").rotateDegrees(-0.8, 150, false);		
		GyroFollow.followDegrees(0.6, 0.3, 0.012, 0, Conversion.cmToDegrees(23), 90, true);
		
		Wait.waitForSeconds(0.3);
		RobotMap.getChassis().tankDriveDegrees(-0.3, 0.3, 60, true);
		Wait.waitForSeconds(0.5);

		RobotMap.getChassis().forwardDriveDegrees(0.7, 0.3, Conversion.cmToDegrees(16), false);
		RobotMap.getMotor("lArm").rotateDegrees(-0.8, 250, false);
		RobotMap.getChassis().forwardDriveDegrees(0.2, 0.6, Conversion.cmToDegrees(18), false);
		Wait.waitForSeconds(0.5);

		RobotMap.getChassis().backwardDriveDegrees(0.1, 0.6, Conversion.cmToDegrees(19), true);
		
		RobotMap.getChassis().tankDriveDegrees(0.3, -0.3, 68, true);
		Wait.waitForSeconds(0.5);
		RobotMap.getChassis().tankDriveDegrees(-0.7, -0.6, 0.4, Conversion.cmToDegrees(45), true);
		RobotMap.getChassis().tankDriveDegrees(-0.8, -0.9, 0.4, Conversion.cmToDegrees(125), true);

	}

}
