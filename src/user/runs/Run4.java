package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Wait;
import user.utils.General.Conversion;
import user.utils.GyroFollow;

public class Run4 extends RobotRun {

	public Run4(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {

		RobotMap.getSensor("gyro").resetToCurrentValue();
		
		/*RobotMap.getChassis().forwardDriveDegrees(0.4, 0.8, Conversion.cmToDegrees(5), false);
		Wait.waitForSeconds(0.3);
		RobotMap.getChassis().tankDriveDegrees(-0.2, 0.2, 80, false);*/
		
		//drive forward a little
		RobotMap.getChassis().forwardDriveDegrees(0.2, 0.6, Conversion.cmToDegrees(4), false);
		Wait.waitForSeconds(0.3);
		
		//turn towards treehouse
		RobotMap.getChassis().tankDriveDegrees(0.2, -0.2, 90, false);
		Wait.waitForSeconds(0.5);
		
		//drive towards treehouse
		GyroFollow.followDegrees(0.5, 0.1, 0.012, 0, Conversion.cmToDegrees(65), 44, false);
		
		
		//slow down to straighten on the treehouse
		RobotMap.getChassis().forwardDriveSeconds(0.2, 0.4, 3, false);
		Wait.waitForSeconds(0.5);
		RobotMap.getMotor("rWheel").rotateDegrees(0.3, 20, false);
		
		//lower blue pieces on the treehouse
		RobotMap.getMotor("rArm").rotateSeconds(0.3, 2.5, false);
		
		//free the arm from the pieces
		RobotMap.getMotor("rArm").rotateDegrees(-0.1, 0.3, 100, true);
		RobotMap.getMotor("rArm").rotateDegrees(-0.1, 0.3, 80, true);
		
		//back off slowly
		RobotMap.getChassis().backwardDriveDegrees(0.3, 0.1, Conversion.cmToDegrees(10), false);
		
		//drive back
		RobotMap.getChassis().tankDriveDegrees(-0.65, -0.8, 0.3, Conversion.cmToDegrees(32), true);
		
		//turn towards the crane
		RobotMap.getChassis().tankDriveDegrees(-0.2, 0.2, 200, false);
		Wait.waitForSeconds(0.5);
		
		//drive and collide with crane
		GyroFollow.followDegrees(0.5, 0.1, 0.012, 0, Conversion.cmToDegrees(35), 0, false);
		
		Wait.waitForSeconds(0.5);
		
		//back up
		RobotMap.getChassis().backwardDriveDegrees(0.5, 0.3, Conversion.cmToDegrees(35), false);
		Wait.waitForSeconds(0.3);
		
		//turn toward circle
		RobotMap.getChassis().tankDriveDegrees(0.5, -0.5, 0.3, 150, true);
		
		//drive toward circle
		RobotMap.getChassis().forwardDriveDegrees(0.3, 0.6, Conversion.cmToDegrees(18), true);
		
		//release adrihalut hadshanit
		RobotMap.getMotor("lArm").rotateDegrees(-1, 720, false);
		
		//back to home
		RobotMap.getChassis().tankDriveSeconds(-0.8, -0.9, 1, 3.5, false);
		
	}
}