package user.runs;

import robot.runs.RobotRun;
import user.utils.NewGyroFollow;

public class TestRun extends RobotRun {

	public TestRun(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		// This run is for testing ideas on the fly | do not delete
		
		NewGyroFollow.followDegrees(0.7, 0.5, 0.02, 5000, 0, true);
	}

}
