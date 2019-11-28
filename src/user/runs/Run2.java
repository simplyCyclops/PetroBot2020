package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.wait.Wait;
import user.utils.General.Conversion;
import user.utils.GyroTurn;
import user.utils.NewGyroFollow;

public class Run2 extends RobotRun {

	public Run2(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		
		RobotMap.getSensor("gyro").resetToCurrentValue();
		
		RobotMap.getChassis().tankDriveDegrees(0.8, 0.8, 0.2, Conversion.cmToDegrees(51), true);
		GyroTurn.turnInPlace(0.1, 47, true);
		NewGyroFollow.followDegrees(0.8, 1.0, 0.012, Conversion.cmToDegrees(30), 47, false);
		NewGyroFollow.followDegrees(0.8, 0.2, 0.012, Conversion.cmToDegrees(98), 47, false);
		
		Wait.waitForSeconds(0.5);
		
		RobotMap.getMotor("lArm").rotateDegrees(0.6, 0.5, 650, true);
		RobotMap.getChassis().backwardDriveDegrees(0.2, 0.4, 150, true);
		RobotMap.getMotor("lArm").rotateDegrees(0.6, 0.5, 300, true);
	}

}
