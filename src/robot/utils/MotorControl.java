package robot.utils;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;

/**
 * Template for controlling the motors using brick buttons like in EV3.
 * This extends RobotRun since it utilizes the threading infrastructure
 * @author John & Wifi
 *
 */
public class MotorControl extends RobotRun {

	public void runInstructions() {

		boolean controllingArms = false;
		int buttonValues;

		LCD.clear();
		LCD.drawString("Now controlling:", 0, 0);
		LCD.drawString("Wheels", 0, 1);
		
		//set your motor speeds here
		/*
		RobotStructure.getInstance().sampleLeftArm.setSpeed(800);
		RobotStructure.getInstance().sampleRightArm.setSpeed(800);
		RobotStructure.getInstance().sampleLeftMotor.setSpeed(800);
		RobotStructure.getInstance().sampleRightMotor.setSpeed(800);
		*/
		
		//TODO: Input your motors below !
		while (!Thread.currentThread().isInterrupted()) {

			buttonValues = Button.getButtons();

			// Check bit flags for UP and DOWN brick buttons
			if ((buttonValues & Button.ID_UP) == Button.ID_UP) {
				if (controllingArms) {
					//RobotStructure.getInstance().sampleLeftArm.forward();
				}
				else {
					//RobotStructure.getInstance().sampleLeftMotor.forward();
				}
			}
			else if ((buttonValues & Button.ID_DOWN) == Button.ID_DOWN) {
				if (controllingArms) {
					//RobotStructure.getInstance().sampleLeftArm.backward();
					}
				else {
					//RobotStructure.getInstance().sampleLeftMotor.backward();
				}
			}
			else {
				if (controllingArms) {
					//RobotStructure.getInstance().sampleLeftArm.stop(true);
				}
				else {
					//RobotStructure.getInstance().sampleLeftMotor.stop(true);
				}
			}
			
			//Check bit flags for RIGHT and LEFT brick buttons
			if ((buttonValues & Button.ID_RIGHT) == Button.ID_RIGHT) {
				if (controllingArms) {
					//RobotStructure.getInstance().sampleRightArm.forward();
				}
				else {
					//RobotStructure.getInstance().sampleRightMotor.forward();
				}
			}
			else if ((buttonValues & Button.ID_LEFT) == Button.ID_LEFT) {
				if (controllingArms) {
					//RobotStructure.getInstance().sampleRightArm.backward();
				}
				else {
					//RobotStructure.getInstance().sampleRightMotor.backward();
				}
			}
			else {
				if (controllingArms) {
					//RobotStructure.getInstance().sampleRightArm.stop(true);
				}
				else {
					//RobotStructure.getInstance().sampleLeftMotor.stop(true);
				}
			}

			//Swap arms and wheels when ENTER is pressed and released
			if (buttonValues == Button.ID_ENTER) {
				while (Button.getButtons() == Button.ID_ENTER && !Thread.currentThread().isInterrupted());
				controllingArms = !controllingArms;
				LCD.clear();
				if (controllingArms)
					LCD.drawString("Arms", 0, 1);
				else
					LCD.drawString("Wheels", 0, 1);
			}

		}

	}

}
