package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import user.utils.General.Conversion;
import user.utils.CircleTurn;
import user.utils.GyroFollow;

public class TestRun extends RobotRun {

	public TestRun(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		// This run is for testing ideas on the fly | do not delete
		RobotMap.getChassis().tankDriveDegrees(0.6, 0.6, Conversion.cmToDegrees(6), false);
		CircleTurn.turn(0.7, 0.8, 7, 40, "left", true);
	}

}
