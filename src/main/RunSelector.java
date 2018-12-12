package main;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;
import robotUtils.RobotRun;
import robotUtils.RobotStructure;

/**
 * Sample master class, in charge of running specific runs.
 * Includes GUI display with an arrow indicator.
 * Arrow is moved using the up and down buttons on the robot, select run with center button.
 * Note that the RobotStructure must be initialized here in order for it to be used in all other programs.
 * TODO: Input your run names, modify to match run count if necessary, edit startNewRun method.
 * 
 * @author John & Wifi
 */

public class RunSelector {
	
	private static String run1Name, run2Name, run3Name, run4Name, run5Name;
	
	private static RobotRun selectedRun;
	
	public static void main(String[] args) {
		
		RobotStructure.getInstance();
		
		int arrowY = 0;
		
		boolean active = true;
		MAIN_LOOP: while(active) {
			
			drawScreen(arrowY);	
			
			switch(Button.getButtons()) {
			
			case Button.ID_UP: 
				while(Button.getButtons() == Button.ID_UP);
				arrowY = Math.max(0, arrowY - 1);
				break;
			case Button.ID_DOWN:
				while(Button.getButtons() == Button.ID_DOWN);
				arrowY = Math.min(5, arrowY + 1);
				break;
			case Button.ID_ENTER:
				while(Button.getButtons() == Button.ID_ENTER);
				startNewRun(arrowY);
				break;
			case Button.ID_ESCAPE: // timer for 2 seconds or until released
				long startTime = System.currentTimeMillis();
				while (Button.getButtons() == Button.ID_ESCAPE) {
					// set active to false if 2 seconds have passed without release
					if (System.currentTimeMillis() - startTime > 2000) {
						System.out.println("will exit on release");
						while (Button.getButtons() == Button.ID_ESCAPE)
							;
						active = false;
						break MAIN_LOOP;
					}
				}
				break;
			}
			
			Delay.msDelay(50);
		}
		
	}
	
	/**
	 * Draws everything that should be displayed on the screen (the arrow and run names)
	 *  
	 * @param yCoord The y coordinate the arrow should be displayed at.
	 */
	private static void drawScreen(int yCoord) {
		LCD.clear();
		
		LCD.drawString("->", 0, yCoord);
		
		LCD.drawString(run1Name, 2, 0);
		LCD.drawString(run2Name, 2, 1);
		LCD.drawString(run3Name, 2, 2);
		LCD.drawString(run4Name, 2, 3);
		LCD.drawString(run5Name, 2, 4);		
	}
	
	/**
	 * Method to start a run depending on selection. Should be called on enter press.
	 * TODO: replace commented code with your runs.
	 * @param runNum
	 */
	private static void startNewRun(int runNum) {
		switch(runNum) {
		case 1:
			//selectedRun = new Run1();
			break;
		case 2:
			//selectedRun = new Run2();
			break;
		case 3:
			//selectedRun = new Run3();
			break;
		case 4:
			//selectedRun = new Run4();
			break;
		case 5:
			//selectedRun = new Run5();
			break;	
		}
		selectedRun.start();
		while(selectedRun.isAlive());
	}
	
	
}