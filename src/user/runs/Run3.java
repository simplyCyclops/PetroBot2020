package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Wait;
import user.utils.General.Conversion;
import user.utils.GyroFollow;

public class Run3 extends RobotRun {

	public Run3(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		RobotMap.getSensor("gyro").resetToCurrentValue();
		
		/*RobotMap.getChassis().forwardDriveDegrees(0.4, 0.8, Conversion.cmToDegrees(5), false);
		Wait.waitForSeconds(0.3);
		RobotMap.getChassis().tankDriveDegrees(-0.2, 0.2, 80, false);*/
		RobotMap.getChassis().forwardDriveDegrees(0.4, 0.6, Conversion.cmToDegrees(15), false);
		Wait.waitForSeconds(0.3);
		RobotMap.getChassis().tankDriveDegrees(0.2, -0.2, 80, false);
		GyroFollow.followDegrees(0.5, 0.1, 0.012, 0, Conversion.cmToDegrees(60), -42, false);
		RobotMap.getChassis().forwardDriveSeconds(0.2, 0.4, 4, false);
		Wait.waitForSeconds(0.5);
		RobotMap.getMotor("rArm").rotateSeconds(0.3, 2.5, false);
		RobotMap.getMotor("rArm").rotateDegrees(-0.1, 90, true);
		RobotMap.getChassis().backwardDriveDegrees(0.6, 0.2, Conversion.cmToDegrees(38), false);
	}

}
