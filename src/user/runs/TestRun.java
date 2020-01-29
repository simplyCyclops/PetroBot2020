package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
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
		/*RobotMap.getSensor("gyro").resetToCurrentValue();
		GyroTurn.turnTo(0.1, 2);
		System.out.println(RobotMap.getSensor("gyro").read());
*/
		CircleTurn.turn(0.6, 0.5, 12, 100, "right", false);
		LineFollow.followDegrees(0.5, Conversion.cmToDegrees(102), 0.02, "rColor", "left", true);
		
		GyroTurn.turnTo(0.1, 0);
		GyroFollow.followDegrees(0.4, 0.4, 0.03, 0, Conversion.cmToDegrees(32), 0, true);
		
		GyroTurn.turnTo(0.1, 90);
		
		RobotMap.getChassis().tankDriveDegrees(0.2, 0.2, Conversion.cmToDegrees(9.2), true);
	}

}
