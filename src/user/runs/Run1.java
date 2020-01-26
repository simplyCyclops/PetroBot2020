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
		
		//drive forward
		GyroFollow.followDegrees(0.4, 0.4, 0.04, 0, Conversion.cmToDegrees(57), 0, true);
		
		//back to home
		RobotMap.getChassis().tankDriveSeconds(-0.5, -1, 2, false);
	}

}
