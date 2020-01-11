package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;

public class TestRun extends RobotRun {

	public TestRun(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		// This run is for testing ideas on the fly | do not delete
		RobotMap.getMotor("lArm").rotateDegrees(-1, 720, false);
	}

}
