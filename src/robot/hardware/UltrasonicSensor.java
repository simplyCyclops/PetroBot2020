package robot.hardware;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

/**
 * Wrapper for LeJOS EV3UltrasonicSensor for simplicity purposes
 * @author John
 *
 */
public class UltrasonicSensor extends EV3UltrasonicSensor{

	private SampleProvider distanceSampler;
	
	public UltrasonicSensor(Port port) {
		super(port);
		distanceSampler = this.getDistanceMode();
	}
	
	/**
	 * @return The distance detected by the sensor, in meters
	 */
	public double getAnbientLight() {
		float[] sampleDump = new float[3];
		double sum = 0;
		for (int i = 0; i < sampleDump.length; i++) {
			distanceSampler.fetchSample(sampleDump, i);
			sum+=sampleDump[i];
		}
		return sum / 3;
	}

}
