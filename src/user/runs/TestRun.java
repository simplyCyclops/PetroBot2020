package user.runs;

import lejos.hardware.Button;
import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Action;
import user.utils.CircleTurn;
import user.utils.GyroFollow;
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
		/*GyroTurn.turnTo(0.1, 2);
		System.out.println(RobotMap.getSensor("gyro").read());
*/
		RobotMap.getChassis().tankDriveDegrees(0.4, 0.4, 0.4, Conversion.cmToDegrees(19), true);
		GyroTurn.turnTo(0.1, 89);
		
		GyroFollow.followDegrees(0.3, 0.4, 0.03, 0, Conversion.cmToDegrees(27), 89, false);

		new Action() {
			
			@Override
			public void execute() {
				RobotMap.getMotor("lArm").rotateDegrees(-0.8, 1000, true);
			}
		}.runInParallel();
		LineFollow.followDegrees(0.4, Conversion.cmToDegrees(115), 0.04, "rColor", "right", true);
		
		GyroTurn.turnTo(0.1, 89);
		GyroFollow.followDegrees(-0.2, 0.4, 0.02, 0, Conversion.cmToDegrees(17), 89, true);
		
		GyroTurn.turnTo(0.1, -1);
		
		GyroFollow.followDegrees(0.2, 0.4, 0.02, 0, Conversion.cmToDegrees(25), -1, true);
		
		GyroTurn.turnTo(0.1, 89);
		
		GyroFollow.followDegrees(0.3, 0.3, 0.02, 0, Conversion.cmToDegrees(40), 89, true);
	}

}
