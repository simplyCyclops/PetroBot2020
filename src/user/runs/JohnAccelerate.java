package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;

public class JohnAccelerate extends RobotRun{

	public JohnAccelerate(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		RobotMap.getMotor("rArm").rotateSeconds(.7, .1, 4, true);
	}

}
