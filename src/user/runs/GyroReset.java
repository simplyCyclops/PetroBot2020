package user.runs;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Condition;
import robot.utils.Wait;

public class GyroReset extends RobotRun {

	String direction = "";
	
	Condition enterPressed = new Condition() {
		
		@Override
		public boolean evaluate() {
			if(Button.getButtons() == Button.ID_ENTER) {
				while (Button.getButtons() == Button.ID_ENTER);
				
				return true;
			}
			return false;
		}
	};
	
	
	public GyroReset(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runInstructions() {
		RobotMap.getSensor("gyro").resetToCurrentValue();
		
		LCD.clear();
		
		//load screen
		LCD.drawString("rotate", 0, 0);
		LCD.drawString("90deg " + direction + "clockwise", 0, 1);
		
		LCD.drawString("Press ENTER", 0, 6);
		LCD.drawString("to continue", 0, 7);
		
		//show gyro value until ENTER is pressed
		while(!enterPressed.loopEvaluate()) {
			LCD.drawInt((int)RobotMap.getSensor("gyro").read(), 0, 3);
		}
		
		LCD.clear();
		
		//if gyro value is not 90 recalibrate and try again
		if(RobotMap.getSensor("gyro").read() != 90) {
			LCD.drawString("recalibrating...", 0, 0);
			
			resetGyro();
			
			LCD.drawString("conplete", 0, 0);
			
			if(direction == "") direction = "counter";
			else direction = "";
			
			runInstructions();
		} else { //else exit
			LCD.drawString("Gyro calibrated", 0, 0);
			Wait.waitForSeconds(0.5);
		}
		
	}

	private void resetGyro() {
		RobotMap.getSensor("gyro").calibrate();
	}
	
}
