package robot.hardware;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import robot.utils.RunHandler;
import util.Wait;

/**
 * Wrapper for LeJOS Ev3LargeRegulatedMotor for simplicity and FLLeJOS run
 * support
 * 
 * @author John
 *
 */
public class LargeMotor extends EV3LargeRegulatedMotor {

	public LargeMotor(Port port) {
		super(port);
	}

	/**
	 * Rotates a single motor for set degrees amount. Does not respect immediateReturn.
	 * @param power Power in degrees / sec. If negative - motor will run backwards
	 * @param deg Degrees to rotate
	 * @param brake Brake or coast the motor
	 */
	public void rotateForDegrees(int power, int deg, boolean brake) {
		int startValue = this.getTachoCount();
		this.setSpeed(Math.abs(power));
		if (power < 0) {
			this.backward();
			while(this.getTachoCount() > startValue - Math.abs(deg) && RunHandler.getCurrentRun().isActive());
		} else {
			this.forward();
			while(this.getTachoCount() < startValue + Math.abs(deg) && RunHandler.getCurrentRun().isActive());
		}
		if(brake) {
			this.stop();
		} else {
			this.flt();
		}
	}

	/**
	 * Rotates a single motor for certain time. Does not respect immediateReturn.
	 * @param power Power in degrees / sec. If negative - motor will run backwards
	 * @param deg Seconds to rotate
	 * @param brake Brake or coast the motor
	 */
	public void rotateForSeconds(int power, double sec, boolean brake) {
		this.setSpeed(Math.abs(power));
		if (power < 0) {
			this.backward();
		} else {
			this.forward();
		}
		Wait.waitForSeconds(sec);
		if(brake) {
			this.stop();
		} else {
			this.flt();
		}
	}

}
