package user.runs;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Wait;
import user.utils.LineFollow;

public class ColorReset extends RobotRun{

	public ColorReset(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runInstructions() {
		LCD.drawString("L on black", 0, 0);
		
		Button.waitForAnyPress();
		
		LineFollow.black = RobotMap.getSensor("lColor").read();
		LCD.clear();
		Wait.waitForSeconds(0.2);
		LCD.drawString("L on white", 0, 0);
		
		Button.waitForAnyPress();
		
		LineFollow.white = RobotMap.getSensor("lColor").read();
		LCD.clear();
		Wait.waitForSeconds(0.2);
		
		LCD.drawString("black: " + LineFollow.black, 0, 0);
		LCD.drawString("white: " + LineFollow.white, 0, 1);
		
		Button.waitForAnyPress();
	}

}
