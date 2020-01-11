package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import user.utils.GyroTurn;

public class Run3 extends RobotRun {

	public Run3(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		RobotMap.getSensor("gyro").resetToCurrentValue();
		
		GyroTurn.turn(0.8, 0.675, 0.3, 28, false);
		//GyroFollow.followDegrees(0.7, 0.3, 0.012, Conversion.cmToDegrees(45), 28, false);
		RobotMap.getMotor("rArm").rotateSeconds(-0.3, 0.5, 0.8, true);
		//GyroFollow.followDegrees(0.7, 0.3, 0.012, Conversion.cmToDegrees(30), 28, false);
		//GyroFollow.followDegrees(0.7, 0.3, 0.012, Conversion.cmToDegrees(30), 28, false);
	}

}
