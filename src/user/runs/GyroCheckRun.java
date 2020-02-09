package user.runs;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Wait;
import user.utils.GyroTurn;

public class GyroCheckRun extends RobotRun{

	public GyroCheckRun(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		
		RobotMap.getSensor("gyro").resetToCurrentValue();
		
		System.out.println(RobotMap.getSensor("gyro").read());
		
		GyroTurn.turnTo(0.1, 90);
		
		System.out.println(RobotMap.getSensor("gyro").read());
	}

}
