package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;

public class Run4 extends RobotRun {

	public Run4(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		RobotMap.getSensor("gyro").resetToCurrentValue();
		
		//GyroFollow.followDegrees(0.6, 0.5, 0.03, Conversion.cmToDegrees(60), 0, true);
		//RobotMap.getChassis().tankDriveDegrees(0.6, 0.6, 0.5, Conversion.cmToDegrees(60), true);
		RobotMap.getChassis().tankDriveSeconds(-0.5, -1, 2, false);
	}

}
