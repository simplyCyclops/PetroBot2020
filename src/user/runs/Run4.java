package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import user.utils.General.Conversion;

public class Run4 extends RobotRun {

	public Run4(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runInstructions() {
		// TODO Auto-generated method stub
		//GyroFollow.followDegrees(0.5, Conversion.cmToDegrees(45), 0, 0.3);
		RobotMap.getChassis().tankDriveDegrees(0.6, 0.6, 0.5, Conversion.cmToDegrees(60), true);
		RobotMap.getChassis().tankDriveSeconds(-0.5, -1, 2, false);
	}

}
