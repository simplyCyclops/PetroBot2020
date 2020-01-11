package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Wait;
import user.utils.General.Conversion;
import user.utils.GyroFollow;
import user.utils.GyroTurn;

public class Run4 extends RobotRun {

	public Run4(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		
		RobotMap.getSensor("gyro").resetToCurrentValue();
		
		RobotMap.getChassis().tankDriveDegrees(0.8, 0.8, 0.2, Conversion.cmToDegrees(50), true);
		GyroTurn.turnInPlace(0.1, 47, true);
		GyroFollow.followDegrees(0.8, 1.0, 0.012, 0.0, Conversion.cmToDegrees(128), 47, false);
		RobotMap.getMotor("lWheel").setAcceleration(0.2);
		RobotMap.getMotor("rWheel").setAcceleration(0.2);
		RobotMap.getChassis().brake();
		
		Wait.waitForSeconds(0.5);
		
		RobotMap.getMotor("lArm").rotateDegrees(0.6, 0.5, 630, true);
		RobotMap.getChassis().backwardDriveDegrees(0.2, 0.4, 130, true);
		RobotMap.getMotor("lArm").rotateDegrees(0.6, 0.5, 530, true);
		
		RobotMap.getChassis().backwardDriveDegrees(0.3, 0.4, 350, true);
		GyroTurn.turnInPlace(0.1, 67, true);
		RobotMap.getChassis().forwardDriveDegrees(0.6, 0.4, 520, true);
	}

}
