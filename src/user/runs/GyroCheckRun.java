package user.runs;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Wait;

public class GyroCheckRun extends RobotRun{

	public GyroCheckRun(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		
		Wait.waitFor(() -> {
			LCD.drawInt((int)RobotMap.getSensor("gyro").read(), 0, 0);
			return Button.getButtons() == Button.ID_ENTER;
		});
		
		
	}

}
