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
		
		RobotMap.getChassis().forwardDriveDegrees(0.2, 0.6, Conversion.cmToDegrees(3.8), false);
		CircleTurn.turn(0.6, 0.3, 33, 102, "right", true);
		GyroFollow.followDegrees(0.6, 0.3, 0.012, 0, Conversion.cmToDegrees(42), 90, false);
		RobotMap.getMotor("rArm").rotateDegrees(-0.8, 150, false);
		Wait.waitForSeconds(0.5);
		GyroFollow.followDegrees(0.6, 0.3, 0.012, 0, Conversion.cmToDegrees(26), 90, true);
		Wait.waitForSeconds(0.3);
		RobotMap.getChassis().tankDriveDegrees(-0.3, 0.3, 60, true);
		Wait.waitForSeconds(0.5);

		RobotMap.getChassis().forwardDriveDegrees(0.7, 0.3, Conversion.cmToDegrees(17), false);
		RobotMap.getMotor("lArm").rotateDegrees(-0.8, 250, false);
		RobotMap.getChassis().forwardDriveDegrees(0.2, 0.6, Conversion.cmToDegrees(17), false);
		Wait.waitForSeconds(0.5);

		RobotMap.getChassis().backwardDriveDegrees(0.1, 0.6, Conversion.cmToDegrees(17), true);

	}

}
