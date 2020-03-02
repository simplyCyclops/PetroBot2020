package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Action;
import robot.utils.Wait;
import user.utils.General.Conversion;
import user.utils.GyroFollow;
import user.utils.GyroTurn;
import user.utils.LineFollow;

public class TestRun extends RobotRun {

	public TestRun(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		// This run is for testing ideas on the fly | do not delete
		
<<<<<<< HEAD
=======
		//reset gyro
		RobotMap.getSensor("gyro").resetToCurrentValue();;

		//drive away from wall
		RobotMap.getChassis().tankDriveDegrees(0.4, 0.4, 0.4, Conversion.cmToDegrees(18), true);
		
		//turn 90 degrees
		GyroTurn.turnTo(0.1, 89);
		
		//drive forward towards line
		GyroFollow.followDegrees(0.3, 0.4, 0.03, 0, Conversion.cmToDegrees(27), 89, false);

		//open arm
		new Action() {
			
			@Override
			public void execute() {
				RobotMap.getMotor("lArm").rotateDegrees(-0.8, 1000, true);
			}
		}.runInParallel();
		
		//follow line at the same time
		LineFollow.followDegrees(0.4, Conversion.cmToDegrees(90), 0.04, "rColor", "right", true);
		
		//straighten
		GyroTurn.turnTo(0.1, 90);
		
		//collide with swing
		RobotMap.getChassis().tankDriveDegrees(0.5, 0.5, 0.4, Conversion.cmToDegrees(28), true);
				
		//drive backward
		RobotMap.getChassis().tankDriveDegrees(-0.4, -0.4, Conversion.cmToDegrees(10), true);
		
		//turn 90 degrees
		GyroTurn.turnTo(0.1, 1);
		
		//drive back to straighten on wall
		RobotMap.getChassis().tankDriveDegrees(-0.3, -0.3, Conversion.cmToDegrees(30), true);
		Wait.waitForSeconds(0.3);
		
		//reset gyro
		RobotMap.getSensor("gyro").resetToCurrentValue();
		
		//drive forward
		RobotMap.getChassis().tankDriveDegrees(0.3, 0.3, Conversion.cmToDegrees(8), false);
		GyroFollow.followDegrees(0.2, 0.4, 0.02, 0, Conversion.cmToDegrees(35), -1, true);
				
		//turn towards safety factor
		GyroTurn.turnTo(0.1, 87);
		
		//drive towards safety factor
		GyroFollow.followDegrees(0.3, 0.3, 0.02, 0, Conversion.cmToDegrees(27), 89, true);
		Wait.waitForSeconds(0.3);
		
		//do safety factor
		RobotMap.getMotor("lArm").rotateDegrees(0.6, 0.5, 650, true);
		RobotMap.getChassis().backwardDriveDegrees(0.2, 0.4, Conversion.cmToDegrees(3.5), true);
		RobotMap.getMotor("lArm").rotateDegrees(0.6, 0.5, 450, true);
		
		Wait.waitForSeconds(0.3);
		
		//drive back to home
		GyroFollow.followDegrees(-0.6, 0.6, 0.02, 0, Conversion.cmToDegrees(230), 88, false);
>>>>>>> branch 'master' of https://github.com/simplyCyclops/PetroBot2020.git
	}

}
