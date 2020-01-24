package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import user.utils.General.Conversion;
import user.utils.GyroFollow;

public class Run1 extends RobotRun {

	public Run1(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		RobotMap.getSensor("gyro").resetToCurrentValue();
		
		GyroFollow.followDegrees(0.6, 0.3, 0.02, 0, Conversion.cmToDegrees(55), 0, true);
		RobotMap.getChassis().tankDriveSeconds(-0.5, -1, 2, false);
	}

}
