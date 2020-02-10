package user.runs;

import lejos.hardware.lcd.LCD;
import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Wait;

public class GyroRecalibrate extends RobotRun{

	public GyroRecalibrate(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		LCD.drawString("Recalibrating", 0, 0);
		Wait.waitForSeconds(0.2);
		
		RobotMap.getSensor("gyro").calibrate();
		
		LCD.drawString("Complete", 0, 0);
		Wait.waitForSeconds(0.2);
	}

}
