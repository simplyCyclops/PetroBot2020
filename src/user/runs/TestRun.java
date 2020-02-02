package user.runs;

import lejos.hardware.Button;
import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Action;
import robot.utils.Wait;
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
		LineFollow.followDegrees(0.4, Conversion.cmToDegrees(90), 0.04, "rColor", "right", true);
		
		GyroTurn.turnTo(0.1, 91);
		
		RobotMap.getChassis().tankDriveDegrees(0.5, 0.5, 0.4, Conversion.cmToDegrees(28), true);
				
		GyroFollow.followDegrees(-0.2, 0.4, 0.02, 0, Conversion.cmToDegrees(20), 89, true);
		
		GyroTurn.turnTo(0.1, -1);
		RobotMap.getChassis().tankDriveDegrees(-0.3, -0.3, Conversion.cmToDegrees(30), true);
		Wait.waitForSeconds(0.3);
		RobotMap.getChassis().tankDriveDegrees(0.3, 0.3, Conversion.cmToDegrees(8), false);
		GyroFollow.followDegrees(0.2, 0.4, 0.02, 0, Conversion.cmToDegrees(37), -1, true);
				
		GyroTurn.turnTo(0.1, 87);
		
		GyroFollow.followDegrees(0.3, 0.3, 0.02, 0, Conversion.cmToDegrees(41), 89, true);
		
		Wait.waitForSeconds(0.3);
		
		RobotMap.getMotor("lArm").rotateDegrees(0.6, 0.5, 650, true);
		RobotMap.getChassis().backwardDriveDegrees(0.2, 0.4, Conversion.cmToDegrees(3.5), true);
		RobotMap.getMotor("lArm").rotateDegrees(0.6, 0.5, 450, true);
		
		Wait.waitForSeconds(0.3);
		
		GyroFollow.followDegrees(0.6, 0.6, 0.02, 0, Conversion.cmToDegrees(230), 0, false);
	}

}
