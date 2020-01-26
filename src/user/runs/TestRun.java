package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import user.utils.GyroTurn;
import user.utils.LineFollow;
import user.utils.General.Conversion;

public class TestRun extends RobotRun {

	public TestRun(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		// This run is for testing ideas on the fly | do not delete
		RobotMap.getSensor("gyro").resetToCurrentValue();
		GyroTurn.turnTo(0.1, 2);
		System.out.println(RobotMap.getSensor("gyro").read());

	}

}
