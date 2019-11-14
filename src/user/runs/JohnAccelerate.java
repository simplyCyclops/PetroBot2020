package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;

public class JohnAccelerate extends RobotRun{

	public JohnAccelerate(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		RobotMap.getMotor("rArm").rotateSeconds(0.8, 0.6, 4, true);
	}

}
