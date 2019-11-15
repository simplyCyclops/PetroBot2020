package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import user.utils.Acceleration;
import user.utils.Acceleration.Accelerator;

public class TestRun extends RobotRun {

	public TestRun(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		// This run is for testing ideas on the fly | do not delete
		
		RobotMap.getMotor("lArm").rotateDegrees(0.6, 0.5, 600, true);
		Acceleration.accelerateSeconds(new Accelerator(0, -0.3), 0.6, true);
		//RobotMap.getChassis().backwardDrive(0.1, 150, true);
		RobotMap.getMotor("lArm").rotateDegrees(0.6, 0.5, 250, true);
		RobotMap.getMotor("lArm").rotateDegrees(.8, .8, 1000, true);
	}

}
