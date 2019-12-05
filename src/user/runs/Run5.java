package user.runs;

import robot.runs.RobotRun;
import user.utils.GyroTurn;

public class Run5 extends RobotRun {

	public Run5(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		GyroTurn.turn(0.7, 0.5, 30, true);
	}

}
