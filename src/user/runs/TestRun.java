package user.runs;

import lejos.utility.Delay;
import robot.RobotMap;
import robot.runs.RobotRun;
import robot.runs.RunHandler;
import robot.utils.Wait;
import user.utils.LineFollow;

public class TestRun extends RobotRun {

	public TestRun(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		// This run is for testing ideas on the fly | do not delete
		
		///LineFollow.untilColor(0.5, 0.7, 0.1, true, false);
		RobotMap.getMotor("lWheel").forward(0.4, 0.5);
		RobotMap.getMotor("rWheel").forward(0.4, 0.5); //TODO: replace with chassis acceleration when implemented
		Wait.waitForSeconds(0.5);
		LineFollow.followDegrees(0.4, 720, 0.25, "rColor", "right");
		
		/*RobotMap.getMotor("lArm").rotateDegrees(0.6, 0.5, 600, true);
		Acceleration.accelerateSeconds(new Accelerator(0, -0.3), 0.6, true);
		//RobotMap.getChassis().backwardDrive(0.1, 150, true);
		RobotMap.getMotor("lArm").rotateDegrees(0.6, 0.5, 250, true);
		RobotMap.getMotor("lArm").rotateDegrees(.8, .8, 1000, true);*/
	}

}
