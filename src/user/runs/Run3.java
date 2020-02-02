package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Wait;
import user.utils.CircleTurn;
import user.utils.General.Conversion;
import user.utils.GyroFollow;

public class Run3 extends RobotRun {

	public Run3(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		//reset gyro
		RobotMap.getSensor("gyro").resetToCurrentValue();
		Wait.waitForSeconds(0.5);
		
		//drive forwrd away from wall
		RobotMap.getChassis().forwardDriveDegrees(0.2, 0.6, Conversion.cmToDegrees(7), true);
		Wait.waitForSeconds(0.3);
		
		//drive in an arc towards red circle
		CircleTurn.turn(0.6, 0.3, 30, 105, "right", true);

		//drive forward to red circle
		GyroFollow.followDegrees(0.6, 0.3, 0.012, 0, Conversion.cmToDegrees(45.5), 90, false);
		
		//rotate right arm to release red building
		RobotMap.getMotor("rArm").rotateDegrees(-0.8, 150, false);	
		
		//continue driving forward
		GyroFollow.followDegrees(0.6, 0.3, 0.012, 0, Conversion.cmToDegrees(23), 90, true);
		Wait.waitForSeconds(0.3);
		RobotMap.getChassis().tankDriveDegrees(-0.3, 0.3, 60, true);
		Wait.waitForSeconds(0.5);
		
		//drive in an arc to yellow circle
		RobotMap.getChassis().forwardDriveDegrees(0.7, 0.3, Conversion.cmToDegrees(16), false);
		
		//rotate left arm to release yellow building
		RobotMap.getMotor("lArm").rotateDegrees(-0.8, 250, false);
		
		//drive to elevator
		RobotMap.getChassis().forwardDriveDegrees(0.2, 0.6, Conversion.cmToDegrees(18), false);
		Wait.waitForSeconds(0.5);

		//drive backward to disconnect from elevator
		RobotMap.getChassis().backwardDriveDegrees(0.1, 0.6, Conversion.cmToDegrees(19), true);
		
		//turn toward home
		RobotMap.getChassis().tankDriveDegrees(0.3, -0.3, 68, true);
		Wait.waitForSeconds(0.5);
		
		//drive home
		RobotMap.getChassis().tankDriveDegrees(-0.72, -0.7, 0.4, Conversion.cmToDegrees(105), false);
		RobotMap.getChassis().tankDriveDegrees(-0.7, -0.8, 0.4, Conversion.cmToDegrees(65), false);
		RobotMap.getChassis().tankDriveDegrees(-0.5, -0.5, Conversion.cmToDegrees(60), false);

	}

}
