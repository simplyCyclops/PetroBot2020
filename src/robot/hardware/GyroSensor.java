package robot.hardware;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.robotics.SampleProvider;

/**
 * Wrapper for LeJOS EV3GyroSensor for simplicity purposes
 * @author John
 *
 */
public class GyroSensor extends EV3GyroSensor{

	private SampleProvider angleSampler;
	private SampleProvider rateSampler;
	private SampleProvider angleAndRateSampler;
	
	public GyroSensor(Port port) {
		super(port);
		angleSampler = this.getAngleMode();
		rateSampler = this.getRateMode();
		angleAndRateSampler = this.getAngleAndRateMode();
	}
	
	/**
	 * @return The gyro sensor's current angle in degrees, respecting sensor resets.
	 */
	public int getAngle() {
		float[] sampleDump = new float[3];
		int sum = 0;
		for (int i = 0; i < sampleDump.length; i++) {
			angleSampler.fetchSample(sampleDump, i);
			sum+=sampleDump[i];
		}
		return sum / 3;
	}
	
	/**
	 * @return The gyro sensor's current velocity in degrees / second
	 */
	public double getRate() {
		float[] sampleDump = new float[3];
		double sum = 0;
		for (int i = 0; i < sampleDump.length; i++) {
			rateSampler.fetchSample(sampleDump, i);
			sum+=sampleDump[i];
		}
		return sum / 3;
	}
	
	/**
	 * @return An array of length 3 containing the gyro sensor's angle in degrees and velocity in degrees / second
	 */
	public double[] getAngleAndRate() {
		float[] sampleDump = new float[6];
		int angleSum = 0;
		double rateSum = 0;
		for (int i = 0; i < sampleDump.length; i+=2) {
			angleAndRateSampler.fetchSample(sampleDump, i);
			angleSum+=sampleDump[i];
			rateSum+=sampleDump[i+1];
		}
		
		double[] ret = new double[2];
		ret[0] = angleSum / 3;
		ret[1] = rateSum / 3;
		return ret;
	}
}
