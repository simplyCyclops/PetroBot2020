package user.runs;

import lejos.utility.Delay;
import robot.RobotMap;
import robot.runs.RobotRun;
import robot.runs.RunHandler;

public class TestRun extends RobotRun {

	public TestRun(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		// This run is for testing ideas on the fly | do not delete
		while(RunHandler.isRunning()) {
			System.out.println(RobotMap.getSensor("lColor").read());
			Delay.msDelay(500);
		}
		//LineFollow.followSeconds(0.4, 10, light, kp, followLeft);
		
		/*RobotMap.getMotor("lArm").rotateDegrees(0.6, 0.5, 600, true);
		Acceleration.accelerateSeconds(new Accelerator(0, -0.3), 0.6, true);
		//RobotMap.getChassis().backwardDrive(0.1, 150, true);
		RobotMap.getMotor("lArm").rotateDegrees(0.6, 0.5, 250, true);
		RobotMap.getMotor("lArm").rotateDegrees(.8, .8, 1000, true);*/
	}

}
